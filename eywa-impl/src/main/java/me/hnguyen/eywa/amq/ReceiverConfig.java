package me.hnguyen.eywa.amq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author hnguyen
 */
@Configuration
public class ReceiverConfig extends RabbitConfig {
    
    @Bean(name="receiverRabbitTemplate")
    public RabbitTemplate receiverRabbitTemplate() {
        RabbitTemplate template = new RabbitTemplate(connectionFactory());
        template.setMessageConverter(jsonMessageConverter());
        return template;
    }
    
}
