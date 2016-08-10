package me.hnguyen.eywa.amq.rabbitmq;

import java.util.List;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

/**
 *
 * @author hnguyen
 */
public interface EywaAMQServerConfig {

    public void initialize();

    public ConnectionFactory getConnectionFactory(String key);

    public List<ConnectionFactory> getConnectionFactories();

    public RabbitTemplate getRabbitTemplate(String key);

    public List<RabbitTemplate> getRabbitTemplates();

    public Exchange getExchange(String key);

    public List<Exchange> getExchanges();

    public AmqpAdmin getAmqpAdmin(String key);

    public List<AmqpAdmin> getAmqAdmins();

    public Queue getQueue(String key);

    public List<Queue> getQueues();

    public Binding getBinding(String key);

    public List<Binding> getBindings();
}
