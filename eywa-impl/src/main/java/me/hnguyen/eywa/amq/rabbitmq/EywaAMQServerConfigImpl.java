package me.hnguyen.eywa.amq.rabbitmq;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import me.hnguyen.eywa.config.dto.BindingDto;
import me.hnguyen.eywa.config.dto.ExchangeDto;
import me.hnguyen.eywa.config.dto.HostDto;
import me.hnguyen.eywa.config.dto.QueueDto;
import me.hnguyen.eywa.config.service.ConfigurationService;
import me.hnguyen.eywa.util.EywaExchangeFactory;
import me.hnguyen.eywa.util.EywaBeanUtils;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import me.hnguyen.eywa.config.service.InitAQMDataService;
import me.hnguyen.eywa.util.EywaBindingFactory;
import me.hnguyen.eywa.util.EywaConnectionFactory;
import me.hnguyen.eywa.util.EywaQueueFactory;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author hnguyen
 */
@Configuration
public class EywaAMQServerConfigImpl implements EywaAMQServerConfig {

    @Inject
    private InitAQMDataService initAQMDataService;
    @Inject
    private ConfigurationService configService;

    private final MessageConverter msgConverter = new Jackson2JsonMessageConverter();

    private final Map<String, ConnectionFactory> amqConnectionFactories = new HashMap<>();

    @PostConstruct
    @Override
    public void initialize() {
        inittializeDataIfAny();
        buildConnectionFactories();
    }

    public MessageConverter getMessageConverter() {
        return this.msgConverter;
    }

    public ConnectionFactory getConnectionFactory(String key) {
        return amqConnectionFactories.get(key);
    }

    @Override
    public List<AmqpAdmin> getAmqAdmins() {
        final List<AmqpAdmin> rabbitAdmins = new ArrayList<>();
        amqConnectionFactories.keySet().stream().map((key) -> {
            RabbitAdmin rabbitAdmin = new RabbitAdmin(amqConnectionFactories.get(key));
            getAMQQueues(key).stream().forEach((queue) -> rabbitAdmin.declareQueue(queue));
            getAMQExchange(key).stream().forEach((exchange) -> rabbitAdmin.declareExchange(exchange));
            getAMQBindings(key).stream().forEach((binding) -> rabbitAdmin.declareBinding(binding));
            return rabbitAdmin;
        }).forEach((rabbitAdmin) -> {
            rabbitAdmins.add(rabbitAdmin);
        });
        return rabbitAdmins;
    }

    private List<Queue> getAMQQueues(String key) {
        List<Queue> amqQueue = new ArrayList<>();
        List<QueueDto> queueDtos = configService.getQueueDtos(key);
        queueDtos.stream().forEach((queueDto) -> {
            amqQueue.add(EywaQueueFactory.createQueue(queueDto));
        });
        return amqQueue;
    }

    private List<Exchange> getAMQExchange(String key) {
        List<Exchange> amqExchanges = new ArrayList<>();
        List<ExchangeDto> exchangeDtos = configService.getExchanges(key);
        exchangeDtos.stream().forEach((exchangeDto) -> {
            amqExchanges.add(EywaExchangeFactory.createExchange(exchangeDto));
        });
        return amqExchanges;
    }

    private List<Binding> getAMQBindings(String key) {
        List<Binding> amqBindings = new ArrayList<>();
        List<BindingDto> bindingDtos = configService.getBindings(key);
        bindingDtos.stream().forEach((bindingDto) -> {
            amqBindings.add(EywaBindingFactory.createBinding(bindingDto));
        });
        return amqBindings;
    }

    private void inittializeDataIfAny() {
        List<HostDto> hostDtos = configService.getHostConfig();
        if (hostDtos.isEmpty()) {
            initAQMDataService.initData();
        }
    }

    private void buildConnectionFactories() {
        List<HostDto> hostDtos = configService.getHostConfig();
        hostDtos.stream().forEach((hostDto) -> {
            amqConnectionFactories.put(EywaBeanUtils.buildConfigBeanKey(hostDto),
                    EywaConnectionFactory.createConnectionFactory(hostDto));
        });
    }
}
