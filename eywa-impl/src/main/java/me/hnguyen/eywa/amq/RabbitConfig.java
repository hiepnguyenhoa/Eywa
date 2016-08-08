package me.hnguyen.eywa.amq;

import javax.inject.Inject;
import me.hnguyen.eywa.amq.rabbitmq.EywaAMQServerConfig;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 *
 * @author hnguyen
 */
@Configuration
@ComponentScan(basePackages = {"me.hnguyen.eywa"})
@PropertySources({
    @PropertySource("classpath:/me/hnguyen/eywa/eywa_rabbitmq_host.properties"),
    @PropertySource("classpath:/me/hnguyen/eywa/eywa_rabbitmq_exchange.properties"),
    @PropertySource("classpath:/me/hnguyen/eywa/eywa_rabbitmq_queue.properties")})
public class RabbitConfig {
    
    @Inject
    private EywaAMQServerConfig eywaAMQServerConfig;
    
    @Bean
    public AmqpAdmin amqpAdmin() {
        RabbitAdmin rabbitAdmin = (RabbitAdmin) eywaAMQServerConfig.getAmqpAdmin("localhost");
        return rabbitAdmin;
    }
    
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

}
