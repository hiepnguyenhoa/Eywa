package me.hnguyen.eywa.amq;

import java.util.List;
import javax.inject.Inject;
import me.hnguyen.eywa.Neo4JContext;
import me.hnguyen.eywa.amq.rabbitmq.EywaAMQServerConfig;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 *
 * @author hnguyen
 */
@EnableRabbit
@ComponentScan(basePackages = {"me.hnguyen.eywa"})
@PropertySources({
    @PropertySource("classpath:/yewa_rabbit_init.properties")})
public class RabbitConfig extends Neo4JContext {

    private static final String DEFAULT_KEY = "localhost_localhost";

    @Inject
    private EywaAMQServerConfig eywaAMQServerConfig;

    @Bean
    public List<AmqpAdmin> amqpAdmins() {
        return eywaAMQServerConfig.getAmqAdmins();
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

}
