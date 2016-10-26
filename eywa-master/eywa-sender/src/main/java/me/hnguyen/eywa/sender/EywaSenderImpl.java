package me.hnguyen.eywa.sender;

import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.MessageConverter;

import me.hnguyen.eywa.amq.service.EywaSender;

/**
 * @author hnguyen
 */
public class EywaSenderImpl implements EywaSender {

    private final RabbitTemplate rabbitTemplate;

    public EywaSenderImpl(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public EywaSenderImpl(ConnectionFactory connectionFactory, String exchangeName, String routingKey) {
        this(connectionFactory, exchangeName, routingKey, null);
    }

    public EywaSenderImpl(ConnectionFactory connectionFactory, String exchangeName, String routingKey, MessageConverter messageConverter) {
        rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setExchange(exchangeName);
        if (routingKey != null) {
            rabbitTemplate.setRoutingKey(routingKey);
        }
        if (messageConverter != null) {
            rabbitTemplate.setMessageConverter(messageConverter);
        }
    }

    public void setMessageConverter(MessageConverter messageConverter) {
        this.rabbitTemplate.setMessageConverter(messageConverter);
    }

    @Override
    public void send(Object message) {
        this.rabbitTemplate.convertAndSend(message);
    }

}
