package me.hnguyen.eywa.amq.rabbitmq;

import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

/**
 *
 * @author hnguyen
 */
public interface EywaAMQServerConfig {

    public RabbitTemplate getRabbitTemplate(String key);

    public Exchange getExchange(String key);
    
    public RabbitAdmin getAmqpAdmin(String key);
}
