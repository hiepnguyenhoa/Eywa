package me.hnguyen.eywa.amq.rabbitmq;

import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;
import me.hnguyen.eywa.amq.service.EywaReceiver;
import me.hnguyen.eywa.config.service.ConfigurationService;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author hnguyen
 */
//@Configuration
//@Qualifier
public class EywaReceiverConfigImpl extends EywaAMQServerConfigImpl{
    
    @Inject
    private ConfigurationService configService;
    
    private final Map<String, EywaReceiver> eywaReceivers = new HashMap<>();
    
    @Bean(name = "rabbitListenerContainerFactory")
    public SimpleRabbitListenerContainerFactory listenerFactory() {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConnectionFactory(this.getConnectionFactory("localhost_localhost"));
        return factory;
    }
    
}
