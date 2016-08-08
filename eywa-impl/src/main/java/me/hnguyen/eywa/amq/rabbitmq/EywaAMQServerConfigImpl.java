package me.hnguyen.eywa.amq.rabbitmq;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import me.hnguyen.eywa.config.bean.ExchangeBean;
import me.hnguyen.eywa.config.dao.ConfigurationDao;
import me.hnguyen.eywa.config.dto.ExchangeDto;
import me.hnguyen.eywa.config.dto.ExchangeDtoImpl;
import me.hnguyen.eywa.config.dto.HostDto;
import me.hnguyen.eywa.config.dto.SenderChannelDto;
import me.hnguyen.eywa.config.service.ConfigurationService;
import me.hnguyen.eywa.util.ExchangeFactory;
import org.apache.commons.lang3.Validate;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 *
 * @author hnguyen
 */
@Component
public class EywaAMQServerConfigImpl implements EywaAMQServerConfig {

    @Inject
    private ConfigurationService configService;
    private final MessageConverter msgConverter = new Jackson2JsonMessageConverter();
    private final Map<String, ConnectionFactory> connFactories = new HashMap<>();
    private final Map<String, Exchange> senderExchangeDtos = new HashMap<>();

    @PostConstruct
    public void initialize() {
        initConnectionFactories();
        initSenderExchange();
    }

    @Override
    public RabbitAdmin getAmqpAdmin(String key) {
        ConnectionFactory connectionFactory = getConnectionFactory(key);
        RabbitAdmin rabbitAdmin = new RabbitAdmin(connectionFactory);
        return rabbitAdmin;
    }

    @Override
    public RabbitTemplate getRabbitTemplate(String key) {
        ConnectionFactory connectionFactory = getConnectionFactory(key);
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        template.setMessageConverter(msgConverter);
        return template;
    }

    @Override
    public Exchange getExchange(String key) {
        Validate.notNull(key);
        return this.senderExchangeDtos.get(key);
    }
    
    @Override
    public List<Exchange> getExchanges(){
        return new ArrayList(this.senderExchangeDtos.values());
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
    private void initSenderExchange() {
        List<SenderChannelDto> _senderChannelDtos = configService.getProducerChannels();
        for (SenderChannelDto senderChannel : _senderChannelDtos) {
            ExchangeDto exchangeDto = this.toExchangeDto(senderChannel.getExchange());
            StringBuilder keyBuilder = new StringBuilder();
            keyBuilder.append(exchangeDto.getKey());
            keyBuilder.append("_");
            keyBuilder.append(exchangeDto.getName());
            senderExchangeDtos.put(keyBuilder.toString(), ExchangeFactory.createExchange(exchangeDto));
        }
    }

    public ConnectionFactory getConnectionFactory(String key) {
        Validate.notNull(key);
        return connFactories.get(key);
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
