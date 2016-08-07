package me.hnguyen.eywa.amq.rabbitmq;


import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

/**
 *
 * @author hnguyen
 */
public class EywaSenderTemplateImpl implements EywaSenderTemplate {

    private RabbitTemplate rabbitTemplate;

    @Override
    public void setRabbitTemplate(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void setExchange(Exchange exchange) {
        this.rabbitTemplate.setExchange(exchange.getName());
    }

    @Override
    public void send(Object message) {
        this.rabbitTemplate.convertAndSend(message);
    }

    @Override
    public void send(String routingkey, Object message) {
        this.rabbitTemplate.convertAndSend(routingkey, message);
    }

    @Override
    public void send(String exchange, String routingKey, Object message) {
        this.rabbitTemplate.convertAndSend(exchange, routingKey, message);
    }

}
