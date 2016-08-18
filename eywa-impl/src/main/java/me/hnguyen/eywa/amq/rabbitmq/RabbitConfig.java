package me.hnguyen.eywa.amq.rabbitmq;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;
import me.hnguyen.eywa.Neo4JContext;
import me.hnguyen.eywa.amq.exception.CreateBindingException;
import me.hnguyen.eywa.amq.exception.CreateExchangeException;
import me.hnguyen.eywa.config.bean.BindingBean;
import me.hnguyen.eywa.config.bean.ExchangeBean;
import me.hnguyen.eywa.config.bean.HostBean;
import me.hnguyen.eywa.config.bean.QueueBean;
import me.hnguyen.eywa.config.dto.BindingDto;
import me.hnguyen.eywa.config.dto.ExchangeDto;
import me.hnguyen.eywa.config.dto.HostDto;
import me.hnguyen.eywa.config.dto.QueueDto;
import me.hnguyen.eywa.config.service.ConfigurationService;
import me.hnguyen.eywa.config.service.InitAQMDataService;
import org.apache.commons.lang3.Validate;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Exchange;
import static org.springframework.amqp.core.ExchangeTypes.DELAYED;
import static org.springframework.amqp.core.ExchangeTypes.DIRECT;
import static org.springframework.amqp.core.ExchangeTypes.FANOUT;
import static org.springframework.amqp.core.ExchangeTypes.HEADERS;
import static org.springframework.amqp.core.ExchangeTypes.SYSTEM;
import static org.springframework.amqp.core.ExchangeTypes.TOPIC;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
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
@ImportResource(value = {"classpath:eywa_config.xml"})
@PropertySources({
    @PropertySource("classpath:/eywa_config.properties")})
public class RabbitConfig extends Neo4JContext implements ApplicationContextAware {

    protected ApplicationContext ac;

    @Inject
    private InitAQMDataService initAQMDataService;
    @Inject
    private ConfigurationService configService;

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

    @Bean(name = "msgConverter")
    public MessageConverter getMessageConverter() {
        return new Jackson2JsonMessageConverter();
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
    public List<ConnectionFactory> getConnectionFactories() {
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

    @Override
    public void setApplicationContext(ApplicationContext ac) throws BeansException {
        this.ac = ac;
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

    static class EywaBindingFactory {

        public static Binding createBinding(BindingBean bindingDto) {
            Validate.notNull(bindingDto);
            return createBinding(
                    EywaQueueFactory.createQueue(bindingDto.getQueue()),
                    EywaExchangeFactory.createExchange(bindingDto.getExchange()),
                    bindingDto.getRouting()
            );
        }

        private static Binding createBinding(Queue amqQueue, Exchange amqExchange, String routingKey) {
            Validate.notNull(amqQueue);
            Validate.notNull(amqExchange);
            Binding binding = null;
            switch (amqExchange.getType()) {
                case DIRECT:
                    binding = createBindingForDirectExchange(amqQueue, (DirectExchange) amqExchange, routingKey);
                    break;
                case TOPIC:
                    binding = createBindingForTopicExchange(amqQueue, (TopicExchange) amqExchange, routingKey);
                    break;
                case FANOUT:
                    binding = createBindingForFanoutExchange(amqQueue, (FanoutExchange) amqExchange);
                    break;
                case HEADERS:
                case SYSTEM:
                case DELAYED:
                default:
                    throw new CreateBindingException();
            }

            return binding;
        }

        private static Binding createBindingForDirectExchange(Queue amqQueue, DirectExchange amqExchange, String routingKey) {
            return BindingBuilder.bind(amqQueue).to(amqExchange).with(routingKey);
        }

        private static Binding createBindingForTopicExchange(Queue amqQueue, TopicExchange amqExchange, String routingKey) {
            return BindingBuilder.bind(amqQueue).to(amqExchange).with(routingKey);
        }

        private static Binding createBindingForFanoutExchange(Queue amqQueue, FanoutExchange amqExchange) {
            return BindingBuilder.bind(amqQueue).to(amqExchange);
        }
    }

    static class EywaExchangeFactory {

        private static final String EXCEPTION_MSG = "Unsupport the exchange type";

        public static Exchange createExchange(ExchangeBean exchangeDto) {
            Validate.notNull(exchangeDto);
            Exchange exchange = null;
            switch (exchangeDto.getType()) {
                case DIRECT:
                    exchange = new DirectExchange(exchangeDto.getName());
                    break;
                case TOPIC:
                    exchange = new TopicExchange(exchangeDto.getName());
                    break;
                case FANOUT:
                    exchange = new FanoutExchange(exchangeDto.getName());
                    break;
                case HEADERS:
                case SYSTEM:
                case DELAYED:
                default:
                    throw new CreateExchangeException(EXCEPTION_MSG);
            }
            return exchange;
        }
    }

    static class EywaQueueFactory {

        public static Queue createQueue(QueueBean queueDto) {
            Validate.notNull(queueDto);
            Queue queue = new Queue(queueDto.getName(), queueDto.isDurable(), queueDto.isExclusive(), queueDto.isAutoDelete());
            return queue;
        }
    }

}
