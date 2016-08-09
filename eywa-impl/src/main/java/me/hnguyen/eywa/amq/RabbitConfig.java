package me.hnguyen.eywa.amq;

import java.util.List;
import javax.inject.Inject;
import me.hnguyen.eywa.amq.rabbitmq.EywaAMQServerConfig;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
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
@EnableRabbit
@ComponentScan(basePackages = {"me.hnguyen.eywa"})
@PropertySources({
    @PropertySource("classpath:/me/hnguyen/eywa/eywa_rabbitmq_host.properties"),
    @PropertySource("classpath:/me/hnguyen/eywa/eywa_rabbitmq_exchange.properties"),
    @PropertySource("classpath:/me/hnguyen/eywa/eywa_rabbitmq_queue.properties")})
public class RabbitConfig {
    
    private static final String DEFAULT_KEY = "localhost";

    @Inject
    private EywaAMQServerConfig eywaAMQServerConfig;

    @Bean
    public AmqpAdmin amqpAdmin() {
        RabbitAdmin rabbitAdmin = (RabbitAdmin) eywaAMQServerConfig.getAmqpAdmin(DEFAULT_KEY);
        return rabbitAdmin;
    }

    @Bean
    public RabbitTemplate rabbitTemplate() {
        return eywaAMQServerConfig.getRabbitTemplate(DEFAULT_KEY);
    }

    @Bean
    public List<Exchange> exchanges() {
        return eywaAMQServerConfig.getExchanges();
    }

    @Bean
    public List<Binding> bindings() {
        return eywaAMQServerConfig.getBindings();
    }

    @Bean
    public List<Queue> queues() {
        return eywaAMQServerConfig.getQueues();
    }

//    @Bean(name = "rabbitListenerContainerFactory")
//    public SimpleRabbitListenerContainerFactory listenerFactory() {
//        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
//        factory.setConnectionFactory(eywaAMQServerConfig.getConnectionFactory(DEFAULT_KEY));
//        return factory;
//    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

}
