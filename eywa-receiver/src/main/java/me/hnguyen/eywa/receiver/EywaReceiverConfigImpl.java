package me.hnguyen.eywa.receiver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import me.hnguyen.eywa.amq.rabbitmq.RabbitConfig;
import me.hnguyen.eywa.amq.service.MessageProcessor;
import me.hnguyen.eywa.config.dto.HostDto;
import me.hnguyen.eywa.config.dto.ReceiverDto;
import me.hnguyen.eywa.config.service.ConfigurationService;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListenerConfigurer;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerEndpoint;
import org.springframework.amqp.rabbit.listener.RabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpoint;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistrar;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author hnguyen
 */
@Configuration
@EnableRabbit
public class EywaReceiverConfigImpl extends RabbitConfig {

    @Inject
    private ConfigurationService configService;

    private final Map<String, RabbitListenerEndpoint> receiverDtos = new HashMap<>();

    @PostConstruct
    private void initReceivers() {
        List<HostDto> hostDtos = configService.getHostConfig();
        for (HostDto hostDto : hostDtos) {
            List<ReceiverDto> receivers = configService.getReceivers(hostDto.getKey());
            for (ReceiverDto receiverDto : receivers) {
                SimpleRabbitListenerEndpoint listenerEndPoint = new SimpleRabbitListenerEndpoint();
                listenerEndPoint.setId(receiverDto.getKeyMap());
                listenerEndPoint.setQueueNames(receiverDto.getQueue().getName());
                MessageProcessor msgProcessor = receiverDto.getMessageProcessor();
                msgProcessor.setMessageConverter(this.ac.getBean(msgProcessor.getConverterName(), MessageConverter.class));
                listenerEndPoint.setMessageListener(msgProcessor);
                receiverDtos.put(receiverDto.getKeyMap(), listenerEndPoint);
            }
        }
        MessageListenerAdapter addapter;
    }

    @Bean
    public SimpleMessageListenerContainer listenerAdapters() {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(this.getConnectionFactory("localhost"));
        container.setQueueNames("eywa.fanout");
        List<MessageListenerAdapter> listenerAdapters = new ArrayList<>();
        List<HostDto> hostDtos = configService.getHostConfig();
        for (HostDto hostDto : hostDtos) {
            List<ReceiverDto> receivers = configService.getReceivers(hostDto.getKey());
            for (ReceiverDto receiverDto : receivers) {
                MessageProcessor msgProcessor = receiverDto.getMessageProcessor();
                MessageConverter converter = this.ac.getBean(msgProcessor.getConverterName(), MessageConverter.class);
                MessageListenerAdapter adapter = new MessageListenerAdapter(msgProcessor, converter);
                adapter.setDefaultListenerMethod("messageProcessing");
                container.setMessageListener(adapter);
            }
        }
        return container;
    }

    @Bean(name = "rabbitListenerContainerFactory")
    public RabbitListenerContainerFactory listenerFactory() {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConnectionFactory(this.getConnectionFactory("localhost"));
        return factory;
    }

//    @Override
//    public void configureRabbitListeners(RabbitListenerEndpointRegistrar registrar) {
//        for (RabbitListenerEndpoint listener : receiverDtos.values()) {
//            registrar.registerEndpoint(listener);
//        }
//    }
}
