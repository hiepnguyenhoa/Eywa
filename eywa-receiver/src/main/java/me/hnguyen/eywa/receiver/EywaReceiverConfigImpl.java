package me.hnguyen.eywa.receiver;

import java.util.List;
import javax.inject.Inject;
import me.hnguyen.eywa.amq.rabbitmq.RabbitConfig;
import me.hnguyen.eywa.amq.service.MessageProcessor;
import me.hnguyen.eywa.config.dto.HostDto;
import me.hnguyen.eywa.config.dto.ReceiverDto;
import me.hnguyen.eywa.config.service.ConfigurationService;
import org.springframework.amqp.core.MessageListener;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListenerConfigurer;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerEndpoint;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.listener.RabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistrar;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author hnguyen
 */
@Configuration
@EnableRabbit
public class EywaReceiverConfigImpl extends RabbitConfig implements RabbitListenerConfigurer {

    @Inject
    private ConfigurationService configService;

    @Bean(name = "rabbitListenerContainerFactory")
    public RabbitListenerContainerFactory listenerAdapters() {
        SimpleRabbitListenerContainerFactory container =  new SimpleRabbitListenerContainerFactory();
        container.setConnectionFactory(this.getConnectionFactory("localhost"));
        return container;
    }

    @Override
    public void configureRabbitListeners(RabbitListenerEndpointRegistrar registrar) {
        List<HostDto> hostDtos = configService.getHostConfig();
        for (HostDto hostDto : hostDtos) {
            List<ReceiverDto> receivers = configService.getReceivers(hostDto.getKey());
            for (ReceiverDto receiverDto : receivers) {
                SimpleRabbitListenerEndpoint endpoint = new SimpleRabbitListenerEndpoint();
                endpoint.setId(receiverDto.getQueue().getKeyMap());
                endpoint.setQueueNames(receiverDto.getQueue().getName());
                endpoint.setMessageListener(createMessageListener(receiverDto, this.getMessageConverter()));
                registrar.registerEndpoint(endpoint);
            }
        }
    }

    private MessageListener createMessageListener(ReceiverDto receiverDto, MessageConverter messageConverter) {
        MessageProcessor messageListener = (MessageProcessor) this.APP_CONTEXT.getBean(receiverDto.getMessageProcessor());
        messageListener.setMessageConverter(messageConverter);
        return messageListener;
    }
}
