package me.hnguyen.eywa.amq.rabbitmq;

import java.util.List;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

/**
 *
 * @author hnguyen
 */
public interface EywaAMQServerConfig {

    public void initialize();

    public ConnectionFactory getConnectionFactory(String key);

    public RabbitTemplate getRabbitTemplate(String key);

    public Exchange getExchange(String key);

    public List<Exchange> getExchanges();

    public RabbitAdmin getAmqpAdmin(String key);

    public Queue getQueue(String key);

    public List<Queue> getQueues();

    public Binding getBinding(String key);

    public List<Binding> getBindings();
}
