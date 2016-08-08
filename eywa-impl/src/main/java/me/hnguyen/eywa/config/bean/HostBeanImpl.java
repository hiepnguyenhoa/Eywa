package me.hnguyen.eywa.config.bean;

import java.util.Objects;
import me.hnguyen.eywa.util.LambdaUtils;
import org.neo4j.ogm.annotation.NodeEntity;
import org.springframework.beans.factory.annotation.Value;

/**
 *
 * @author hnguyen
 */
@NodeEntity(label = "Host")
public class HostBeanImpl extends ConfigBeanAbst implements HostBean {

    @Value("${host.name}")
    private String name;
    @Value("${host.port}")
    private int port;
    @Value("${host.username}")
    private String username;
    @Value("${host.password}")
    private String password;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getPortNumber() {
        return port;
    }

    @Override
    public void setPortNumber(int port) {
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

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof HostBeanImpl)) {
            return false;
        }

        HostBeanImpl tmp = (HostBeanImpl) obj;
        return LambdaUtils.compare_object.apply(this.name, tmp.getName())
                || (this.port == tmp.getPortNumber());
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + this.port;
        hash = 31 * hash + Objects.hashCode(this.name);
        return hash;
    }

}
