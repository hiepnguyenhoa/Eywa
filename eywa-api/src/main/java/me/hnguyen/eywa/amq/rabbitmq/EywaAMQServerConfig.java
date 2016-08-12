package me.hnguyen.eywa.amq.rabbitmq;

import java.util.List;
import org.springframework.amqp.core.AmqpAdmin;

/**
 *
 * @author hnguyen
 */
public interface EywaAMQServerConfig {

    public void initialize();

    public List<AmqpAdmin> getAmqAdmins();

}
