package me.hnguyen.eywa.amq.rabbitmq;

import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author hnguyen
 */
//@Configuration
//@Qualifier("eywaSendAndReceiveConfig")
public class EywaSendAndReceiveConfig extends EywaSenderConfigImpl {
    
    @Bean(name = "rabbitListenerContainerFactory")
    public SimpleRabbitListenerContainerFactory listenerFactory() {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConnectionFactory(this.getConnectionFactory("localhost_localhost"));
        return factory;
    }
    
}
