package me.hnguyen.eywa.amq.rabbitmq;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import me.hnguyen.eywa.config.bean.ExchangeBean;
import me.hnguyen.eywa.config.dto.BindingDto;
import me.hnguyen.eywa.config.dto.ExchangeDto;
import me.hnguyen.eywa.config.dto.ExchangeDtoImpl;
import me.hnguyen.eywa.config.dto.HostDto;
import me.hnguyen.eywa.config.dto.QueueDto;
import me.hnguyen.eywa.config.dto.ReceiverDto;
import me.hnguyen.eywa.config.service.ConfigurationService;
import me.hnguyen.eywa.util.BindingFactory;
import me.hnguyen.eywa.util.ExchangeFactory;
import me.hnguyen.eywa.util.EywaBeanUtils;
import org.apache.commons.lang3.Validate;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import me.hnguyen.eywa.config.dto.SenderDto;
import me.hnguyen.eywa.config.entity.ReceiverEntity;
import me.hnguyen.eywa.config.service.InitAQMDataService;

/**
 *
 * @author hnguyen
 */
@Component
public class EywaAMQServerConfigImpl implements EywaAMQServerConfig {

    @Inject
    private InitAQMDataService initAQMDataService;
    @Inject
    private ConfigurationService configService;
    private final MessageConverter msgConverter = new Jackson2JsonMessageConverter();
    private final Map<String, ConnectionFactory> connFactories = new HashMap<>();
    private final Map<String, Exchange> amqExchanges = new HashMap<>();
    private final Map<String, Queue> amqQueues = new HashMap<>();
    private final Map<String, Binding> amqBindings = new HashMap<>();

    @PostConstruct
    @Override
    public void initialize() {
        initialData();
        initConnectionFactories();
        initSender();
        initReceiver();
        initExchanges();
        initQueues();
        bindings();
    }

    @Override
    public RabbitAdmin getAmqpAdmin(String key) {
        ConnectionFactory connectionFactory = getConnectionFactory(key);
        RabbitAdmin rabbitAdmin = new RabbitAdmin(connectionFactory);
        return rabbitAdmin;
    }

    @Override
    public RabbitTemplate getRabbitTemplate(String key) {
        Validate.notNull(key);
        ConnectionFactory connectionFactory = getConnectionFactory(key);
        Exchange exchange = getExchange(key);
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        if (exchange != null) {
            template.setExchange(exchange.getName());
        }
        template.setMessageConverter(msgConverter);
        return template;
    }

    @Override
    public Queue getQueue(String key) {
        Validate.notNull(key);
        return this.amqQueues.get(key);
    }

    @Override
    public List<Queue> getQueues() {
        return new ArrayList(this.amqQueues.values());
    }

    @Override
    public Exchange getExchange(String key) {
        Validate.notNull(key);
        return this.amqExchanges.get(key);
    }

    @Override
    public List<Exchange> getExchanges() {
        return new ArrayList(this.amqExchanges.values());
    }

    @Override
    public ConnectionFactory getConnectionFactory(String key) {
        Validate.notNull(key);
        return connFactories.get(key);
    }

    @Override
    public Binding getBinding(String key) {
        Validate.notNull(key);
        return this.amqBindings.get(key);
    }

    @Override
    public List<Binding> getBindings() {
        return new ArrayList(this.amqBindings.values());
    }
    
    private void initialData(){
        List<HostDto> hostDtos = configService.getHostConfig();
        if(hostDtos.isEmpty()){
            initAQMDataService.initData();
        }
    }

    private void initConnectionFactories() {
        List<HostDto> hostDtos = configService.getHostConfig();
        hostDtos.stream().forEach((hostDto) -> {
            connFactories.put(hostDto.getKey(), createConnectionFactory(hostDto));
        });
    }

    /**
     * TODO: expected ExchangeDto but ExchangeBean. remove toExchangeDto() when
     * fixed
     */
    private void initSender() {
        List<SenderDto> senderDtos = configService.getSenders();
        for (SenderDto senderChannel : senderDtos) {
            ExchangeDto exchangeDto = this.toExchangeDto(senderChannel.getExchange());
            String key = EywaBeanUtils.buildConfigBeanKey(exchangeDto);
            amqExchanges.put(key, ExchangeFactory.createExchange(exchangeDto));
        }
    }
    
    private void initReceiver(){
        List<ReceiverDto> receiverDtos = configService.getReceivers();
        
    }
    
    private void initExchanges() {
        List<ExchangeDto> exchangeDtos = configService.getExchanges();
        exchangeDtos.stream().forEach((exchangeDto)->{
            String key = EywaBeanUtils.buildConfigBeanKey(exchangeDto);
            Exchange amqQxchange = ExchangeFactory.createExchange(exchangeDto);
            amqExchanges.put(key, amqQxchange);
        });
    }

    private void initQueues() {
        List<QueueDto> queueDtos = configService.getQueueDtos();
        queueDtos.stream().forEach((queueDto) -> {
            String key = EywaBeanUtils.buildConfigBeanKey(queueDto);
            Queue amqQueue = new Queue(
                    queueDto.getName(),
                    queueDto.isDurable(),
                    queueDto.isExclusive(),
                    queueDto.isAutoDelete());
            this.amqQueues.put(key, amqQueue);
        });
    }

    private void bindings() {
        List<BindingDto> bindingDtos = configService.getBindings();
        bindingDtos.stream().forEach((bindingDto) -> {
            String key = EywaBeanUtils.buildConfigBeanKey(bindingDto);
            Binding binding = buildAMQBinding(bindingDto);
            this.amqBindings.put(key, binding);
        });
    }

    private Binding buildAMQBinding(BindingDto bindingDto) {
        String key = EywaBeanUtils.buildConfigBeanKey(bindingDto);
        Queue queue = getQueue(key);
        Exchange exchange = getExchange(key);
        return BindingFactory.createBinding(queue, exchange, key);
    }

    private ConnectionFactory createConnectionFactory(HostDto hostDto) {
        Validate.notNull(hostDto);
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setHost(hostDto.getName());
        connectionFactory.setUsername(hostDto.getUsername());
        connectionFactory.setPassword(hostDto.getPassword());
        return connectionFactory;
    }

    private ExchangeDto toExchangeDto(ExchangeBean exchangeBean) {
        ExchangeDto exchangeDto = new ExchangeDtoImpl();
        BeanUtils.copyProperties(exchangeBean, exchangeDto);
        return exchangeDto;
    }

    

}
