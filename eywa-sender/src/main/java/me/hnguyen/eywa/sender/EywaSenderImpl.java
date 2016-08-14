package me.hnguyen.eywa.sender;

import me.hnguyen.eywa.amq.service.EywaSender;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

/**
 *
 * @author hnguyen
 */
public class EywaSenderImpl implements EywaSender {

    private final RabbitTemplate rabbitTemplate;
    
    public EywaSenderImpl(RabbitTemplate rabbitTemplate){
        this.rabbitTemplate=rabbitTemplate;
    }

    public EywaSenderImpl(ConnectionFactory connectionFactory, String exchangeName, String routingKey) {
        rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setExchange(exchangeName);
        if (routingKey != null) {
            rabbitTemplate.setRoutingKey(routingKey);
        }
    }

    @Override
    public void send(Object message) {
            this.rabbitTemplate.convertAndSend(message);
    }
    
}
