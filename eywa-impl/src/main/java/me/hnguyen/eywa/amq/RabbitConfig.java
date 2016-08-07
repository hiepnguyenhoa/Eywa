package me.hnguyen.eywa.amq;

import me.hnguyen.eywa.util.ExchangeFactory;
import me.hnguyen.eywa.config.dto.ExchangeDto;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.context.annotation.Bean;
import me.hnguyen.eywa.config.dto.HostDto;
import me.hnguyen.eywa.config.service.ConfigurationService;
import me.hnguyen.eywa.config.service.ConfigurationServiceImpl;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import me.hnguyen.eywa.config.dto.SenderChannelDto;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;

/**
 *
 * @author hnguyen
 */
@Configuration
@ComponentScan(basePackages = {"me.hnguyen.eywa"})
@PropertySources({
    @PropertySource("classpath:/me/hnguyen/eywa/eywa_rabbitmq_host.properties"),
    @PropertySource("classpath:/me/hnguyen/eywa/eywa_rabbitmq_exchange.properties"),
    @PropertySource("classpath:/me/hnguyen/eywa/eywa_rabbitmq_queue.properties")})
public class RabbitConfig {

    @Autowired
    protected ConfigurationService configService;

    @Bean
    public ConnectionFactory connectionFactory() {
        HostDto hostDto = configService.getHostConfig();
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setHost(hostDto.getName());
        connectionFactory.setUsername(hostDto.getUsername());
        connectionFactory.setPassword(hostDto.getPassword());
        return connectionFactory;
    }

    @Bean
    public AmqpAdmin amqpAdmin() {
        RabbitAdmin rabbitAdmin = new RabbitAdmin(connectionFactory());
        return rabbitAdmin;
    }

    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public Exchange getExchange() {
        SenderChannelDto producerChannelDto = configService.getProducerChannel();
        return ExchangeFactory.createExchange((ExchangeDto) producerChannelDto.getExchange());
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

}
