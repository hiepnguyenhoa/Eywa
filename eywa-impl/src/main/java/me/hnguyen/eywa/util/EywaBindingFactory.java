package me.hnguyen.eywa.util;

import me.hnguyen.eywa.amq.exception.CreateBindingException;
import me.hnguyen.eywa.config.bean.BindingBean;
import me.hnguyen.eywa.config.bean.QueueBean;
import me.hnguyen.eywa.config.dto.BindingDto;
import org.apache.commons.lang3.Validate;
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
public class EywaBindingFactory {

    public static Binding createBinding(BindingBean bindingDto) {
        Validate.notNull(bindingDto);
        return createBinding(
                EywaQueueFactory.createQueue(bindingDto.getQueue()),
                EywaExchangeFactory.createExchange(bindingDto.getExchange()),
                bindingDto.getRoutingKey()
        );
    }

    private static Binding createBinding(Queue amqQueue, Exchange amqExchange, String routingKey) {
        Validate.notNull(amqQueue);
        Validate.notNull(amqExchange);
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

    private static Binding createBindingForDirectExchange(Queue amqQueue, DirectExchange amqExchange, String routingKey) {
        return BindingBuilder.bind(amqQueue).to(amqExchange).with(routingKey);
    }

    private static Binding createBindingForTopicExchange(Queue amqQueue, TopicExchange amqExchange, String routingKey) {
        return BindingBuilder.bind(amqQueue).to(amqExchange).with(routingKey);
    }

    private static Binding createBindingForFanoutExchange(Queue amqQueue, FanoutExchange amqExchange) {
        return BindingBuilder.bind(amqQueue).to(amqExchange);
    }

}
