package me.hnguyen.eywa.util;

import me.hnguyen.eywa.amq.exception.CreateBindingException;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Exchange;
import static org.springframework.amqp.core.ExchangeTypes.DELAYED;
import static org.springframework.amqp.core.ExchangeTypes.DIRECT;
import static org.springframework.amqp.core.ExchangeTypes.FANOUT;
import static org.springframework.amqp.core.ExchangeTypes.HEADERS;
import static org.springframework.amqp.core.ExchangeTypes.SYSTEM;
import static org.springframework.amqp.core.ExchangeTypes.TOPIC;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;

/**
 *
 * @author hnguyen
 */
public class BindingFactory {

    public static Binding createBinding(Queue amqQueue, Exchange amqExchange, String routingKey) {
        Binding binding = null;
        switch (amqExchange.getType()) {
            case DIRECT:
                binding = createBindingForDirectExchange(amqQueue, (DirectExchange) amqExchange, routingKey);
                break;
            case TOPIC:
                binding = createBindingForTopicExchange(amqQueue, (TopicExchange) amqExchange, routingKey);
                break;
            case FANOUT:
                binding = createBindingForFanoutExchange(amqQueue, (FanoutExchange) amqExchange);
                break;
            case HEADERS:
            case SYSTEM:
            case DELAYED:
            default:
                throw new CreateBindingException();
        }

        return binding;
    }

    public static Binding createBindingForDirectExchange(Queue amqQueue, DirectExchange amqExchange, String routingKey) {
        return BindingBuilder.bind(amqQueue).to(amqExchange).with(routingKey);
    }

    public static Binding createBindingForTopicExchange(Queue amqQueue, TopicExchange amqExchange, String routingKey) {
        return BindingBuilder.bind(amqQueue).to(amqExchange).with(routingKey);
    }

    public static Binding createBindingForFanoutExchange(Queue amqQueue, FanoutExchange amqExchange) {
        return BindingBuilder.bind(amqQueue).to(amqExchange);
    }
}
