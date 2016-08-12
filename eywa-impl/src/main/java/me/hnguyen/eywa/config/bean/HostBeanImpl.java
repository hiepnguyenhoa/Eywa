package me.hnguyen.eywa.config.bean;

import org.springframework.beans.factory.annotation.Value;

/**
 *
 * @author hnguyen
 */
public class HostBeanImpl extends ConfigBeanAbst implements HostBean {

    @Value("${amq.port:5672}")
    private int port;
    @Value("${amq.username:guest}")
    private String username;
    @Value("${amq.password:guest}")
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
