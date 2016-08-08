package me.hnguyen.eywa.amq.rabbitmq;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import org.apache.commons.lang3.Validate;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

/**
 *
 * @author hnguyen
 */
@Component
public class EywaSenderTemplateImpl implements EywaSenderTemplate {

    private static final String TMP_HOST_KEY = "localhost";
    private static final String TMP_EXCHANGE_KEY = "localhost_localhost.fanout";

    @Inject
    private EywaAMQServerConfig serverConfig;
    private RabbitTemplate rabbitTemplate;

    @PostConstruct
    public void rabbitTemplate() {
        rabbitTemplate = serverConfig.getRabbitTemplate(TMP_HOST_KEY);
        rabbitTemplate.setExchange(serverConfig.getExchange(TMP_EXCHANGE_KEY).getName());
    }

    @Override
    public void setRabbitTemplate(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void setExchange(Exchange exchange) {
        Validate.notNull(exchange);
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
