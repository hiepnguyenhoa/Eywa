package me.hnguyen.eywa.amq.rabbitmq;

import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

/**
 *
 * @author hnguyen
 */
public interface EywaSenderTemplate extends EywaRabbitTemplate {

    public void setRabbitTemplate(RabbitTemplate rabbitTemplate);

    public void setExchange(Exchange exchange);

    void send(Object message);

    void send(String routingkey, Object message);

    void send(String exchange, String routingKey, Object message);

}
