package me.hnguyen.eywa.config.bean;

import org.neo4j.ogm.annotation.NodeEntity;
import org.springframework.beans.factory.annotation.Value;

/**
 *
 * @author hnguyen
 */
@NodeEntity
public class HostBeanImpl extends ConfigBeanAbst implements HostBean {

    @Value("${amq.port:5672}")
    private int port;
    @Value("${amq.username}")
    private String username;
    @Value("${amq.password}")
    private String password;

    @Override
    public int getPort() {
        return port;
    }

    @Override
    public void setPort(int port) {
        this.port = port;
    }
    
    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

}
