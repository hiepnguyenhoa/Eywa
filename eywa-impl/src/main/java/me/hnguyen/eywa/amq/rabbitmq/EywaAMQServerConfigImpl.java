package me.hnguyen.eywa.amq.rabbitmq;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import me.hnguyen.eywa.config.bean.ExchangeBean;
import me.hnguyen.eywa.config.bean.QueueBean;
import me.hnguyen.eywa.config.dto.BindingDto;
import me.hnguyen.eywa.config.dto.ExchangeDto;
import me.hnguyen.eywa.config.dto.ExchangeDtoImpl;
import me.hnguyen.eywa.config.dto.HostDto;
import me.hnguyen.eywa.config.dto.ReceiverDto;
import me.hnguyen.eywa.config.service.ConfigurationService;
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
import me.hnguyen.eywa.config.service.InitAQMDataService;
import me.hnguyen.eywa.util.BindingFactory;
import me.hnguyen.eywa.util.QueueFactory;
import org.springframework.amqp.core.AmqpAdmin;

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

    private List<SenderDto> senderDtos;
    private List<ReceiverDto> receiverDtos;
    private List<BindingDto> bindingDtos;

    private final Map<String, ConnectionFactory> connFactories = new HashMap<>();
    private final Map<String, Exchange> amqExchanges = new HashMap<>();
    private final Map<String, Queue> amqQueues = new HashMap<>();
    private final Map<String, Binding> amqBindings = new HashMap<>();

    @PostConstruct
    @Override
    public void initialize() {
        initialData();
        initConnections();
        initBindings();
        initSenders();
        initReceivers();
    }

    @Override
    public List<AmqpAdmin> getAmqAdmins() {
        final List<AmqpAdmin> rabbitAdmins = new ArrayList<>();
        for(ConnectionFactory connFactory: connFactories.values()){
            RabbitAdmin rabbitAdmin = new RabbitAdmin(connFactory);
            for(Queue queue:amqQueues.values()){
                rabbitAdmin.declareQueue(queue);
            };
            for(Exchange exchange:amqExchanges.values()){
                rabbitAdmin.declareExchange(exchange);
            };
            for(Binding  binding:amqBindings.values()){
                rabbitAdmin.declareBinding(binding);
            };
            rabbitAdmins.add(rabbitAdmin);
        };
        return rabbitAdmins;
    }

    @Override
    public RabbitAdmin getAmqpAdmin(String key) {
        ConnectionFactory connectionFactory = getConnectionFactory(key);
        RabbitAdmin rabbitAdmin = new RabbitAdmin(connectionFactory);
        return rabbitAdmin;
    }
    
    @Override
    public List<RabbitTemplate> getRabbitTemplates(){
        List<ConnectionFactory> connFacts = getConnectionFactories();
        List<RabbitTemplate> rabbitTemplates = new ArrayList<>();
        for(ConnectionFactory connFact: connFacts){
            RabbitTemplate template = new RabbitTemplate(connFact);
            rabbitTemplates.add(template);
        }
        return rabbitTemplates;
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
    public List<ConnectionFactory> getConnectionFactories(){
        return new ArrayList(this.connFactories.values());
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

    private void initialData() {
        List<HostDto> hostDtos = configService.getHostConfig();
        if (hostDtos.isEmpty()) {
            initAQMDataService.initData();
        }
    }

    private void initConnections() {
        List<HostDto> hostDtos = configService.getHostConfig();
        hostDtos.stream().forEach((hostDto) -> {
            connFactories.put(EywaBeanUtils.buildConfigBeanKey(hostDto), createConnectionFactory(hostDto));
        });
    }

    /**
     * TODO: expected ExchangeDto but ExchangeBean. remove toExchangeDto() when
     * fixed
     */
    private void initSenders() {
        senderDtos = configService.getSenders();
        for (SenderDto senderChannel : senderDtos) {
            ExchangeDto exchangeDto = this.toExchangeDto(senderChannel.getExchange());
            String key = EywaBeanUtils.buildConfigBeanKey(exchangeDto);
            amqExchanges.put(key, ExchangeFactory.createExchange(exchangeDto));
        }
    }

    private void initReceivers() {
        receiverDtos = configService.getReceivers();
        for (ReceiverDto receiverDto : receiverDtos) {
            List<QueueBean> queueDtos = receiverDto.getQueues();
            for (QueueBean queueDto : queueDtos) {
                String key = EywaBeanUtils.buildConfigBeanKey(queueDto);
                Queue amqQueue = new Queue(
                        queueDto.getName(),
                        queueDto.isDurable(),
                        queueDto.isExclusive(),
                        queueDto.isAutoDelete());
                this.amqQueues.put(key, amqQueue);
            }
        }
    }
    
    private void initBindings(){
        bindingDtos = configService.getBindings();
        bindingDtos.stream().forEach((bindingDto) -> {
            Queue queue = QueueFactory.createQueue(bindingDto.getQueue());
            Exchange exchange = ExchangeFactory.createExchange(bindingDto.getExchange());
            Binding binding = BindingFactory.createBinding(queue, exchange, bindingDto.getRoutingKey());
            amqBindings.put(EywaBeanUtils.buildConfigBeanKey(bindingDto), binding);
            amqQueues.put(EywaBeanUtils.buildConfigBeanKey(bindingDto.getQueue()), queue);
        });
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
