package me.hnguyen.eywa.config.bean;

import org.neo4j.ogm.annotation.NodeEntity;
import org.springframework.beans.factory.annotation.Value;

/**
 *
 * @author hnguyen
 */
@NodeEntity
public class HostBeanImpl extends ConfigBeanAbst implements HostBean {

    @Value("${host.username}")
    private String username;
    @Value("${host.password}")
    private String password;

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
