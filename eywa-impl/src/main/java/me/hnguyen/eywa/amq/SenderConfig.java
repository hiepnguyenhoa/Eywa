package me.hnguyen.eywa.amq;

import me.hnguyen.eywa.amq.rabbitmq.EywaSenderTemplateImpl;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import me.hnguyen.eywa.amq.rabbitmq.EywaSenderTemplate;

/**
 *
 * @author hnguyen
 */
@Configuration
public class SenderConfig extends RabbitConfig {
    
    @Bean(name="senderRabbitTemplate")
    public RabbitTemplate senderRabbitTemplate() {
        RabbitTemplate template = new RabbitTemplate(connectionFactory());
        template.setMessageConverter(jsonMessageConverter());
        return template;
    }

    @Bean
    public EywaSenderTemplate eywaSenderTemplate() {
        RabbitTemplate rabbitTemplate = senderRabbitTemplate();
        EywaSenderTemplate eywaTemplate = new EywaSenderTemplateImpl();
        eywaTemplate.setRabbitTemplate(rabbitTemplate);
        eywaTemplate.setExchange(getExchange());
        return eywaTemplate;
    }
    
}
