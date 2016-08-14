package me.hnguyen.eywa.amq.rabbitmq;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;
import me.hnguyen.eywa.Neo4JContext;
import me.hnguyen.eywa.config.bean.HostBean;
import me.hnguyen.eywa.config.dto.BindingDto;
import me.hnguyen.eywa.config.dto.ExchangeDto;
import me.hnguyen.eywa.config.dto.HostDto;
import me.hnguyen.eywa.config.dto.QueueDto;
import me.hnguyen.eywa.config.service.ConfigurationService;
import me.hnguyen.eywa.config.service.InitAQMDataService;
import me.hnguyen.eywa.util.EywaBeanUtils;
import me.hnguyen.eywa.util.EywaBindingFactory;
import me.hnguyen.eywa.util.EywaExchangeFactory;
import me.hnguyen.eywa.util.EywaQueueFactory;
import org.apache.commons.lang3.Validate;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
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
    @PropertySource("classpath:/yewa_rabbit_init.properties")})
public class RabbitConfig extends Neo4JContext {

    @Inject
    private InitAQMDataService initAQMDataService;
    @Inject
    private ConfigurationService configService;

    private final MessageConverter msgConverter = new Jackson2JsonMessageConverter();

    private final Map<String, CachingConnectionFactory> amqConnectionFactories = new HashMap<>();

    @PostConstruct
    public void initialize() {
        inittializeDataIfAny();
        buildConnectionFactories();
    }

    @PreDestroy
    public void destroy() {
        amqConnectionFactories.values().stream().forEach((connFact) -> connFact.destroy());
    }

    @Bean
    public MessageConverter getMessageConverter() {
        return this.msgConverter;
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
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
    
    @Bean
    public List<ConnectionFactory> getConnectionFactories(){
        return new ArrayList(amqConnectionFactories.values());
    }

    protected ConnectionFactory getConnectionFactory(String key) {
        return amqConnectionFactories.get(key);
    }

    protected List<Queue> getAMQQueues(String key) {
        List<Queue> amqQueue = new ArrayList<>();
        List<QueueDto> queueDtos = configService.getQueueDtos(key);
        queueDtos.stream().forEach((queueDto) -> {
            amqQueue.add(EywaQueueFactory.createQueue(queueDto));
        });
        return amqQueue;
    }

    protected List<Exchange> getAMQExchange(String key) {
        List<Exchange> amqExchanges = new ArrayList<>();
        List<ExchangeDto> exchangeDtos = configService.getExchanges(key);
        exchangeDtos.stream().forEach((exchangeDto) -> {
            amqExchanges.add(EywaExchangeFactory.createExchange(exchangeDto));
        });
        return amqExchanges;
    }

    protected List<Binding> getAMQBindings(String key) {
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
            amqConnectionFactories.put(hostDto.getKeyMap(),
                    EywaConnectionFactory.createConnectionFactory(hostDto));
        });
    }

    static class EywaConnectionFactory {

        public static CachingConnectionFactory createConnectionFactory(HostBean hostDto) {
            Validate.notNull(hostDto);
            CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
            connectionFactory.setHost(hostDto.getName());
            connectionFactory.setPort(hostDto.getPort());
            connectionFactory.setUsername(hostDto.getUsername());
            connectionFactory.setPassword(hostDto.getPassword());
            return connectionFactory;
        }
    }

}
