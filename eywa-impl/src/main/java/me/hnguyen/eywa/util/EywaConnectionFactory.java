package me.hnguyen.eywa.util;

import me.hnguyen.eywa.config.bean.HostBean;
import me.hnguyen.eywa.config.dto.HostDto;
import org.apache.commons.lang3.Validate;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;

/**
 *
 * @author hnguyen
 */
public class EywaConnectionFactory {
    
    public static ConnectionFactory createConnectionFactory(HostBean hostDto) {
        Validate.notNull(hostDto);
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setHost(hostDto.getName());
        connectionFactory.setPort(hostDto.getPort());
        connectionFactory.setUsername(hostDto.getUsername());
        connectionFactory.setPassword(hostDto.getPassword());
        return connectionFactory;
    }
}
