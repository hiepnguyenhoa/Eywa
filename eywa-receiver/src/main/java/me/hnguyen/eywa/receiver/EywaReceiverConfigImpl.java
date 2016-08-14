package me.hnguyen.eywa.receiver;

import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;
import me.hnguyen.eywa.amq.rabbitmq.RabbitConfig;
import me.hnguyen.eywa.amq.service.EywaReceiver;
import me.hnguyen.eywa.config.service.ConfigurationService;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.listener.RabbitListenerContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author hnguyen
 */
@Configuration
public class EywaReceiverConfigImpl extends RabbitConfig{
    
    @Inject
    private ConfigurationService configService;
    
    private final Map<String, EywaReceiver> eywaReceivers = new HashMap<>();
    
    @Bean(name = "rabbitListenerContainerFactory")
    public RabbitListenerContainerFactory listenerFactory() {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConnectionFactory(this.getConnectionFactory("localhost"));
        return factory;
    }
    
}
