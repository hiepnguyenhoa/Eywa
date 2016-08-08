package me.hnguyen.eywa.config.bean;

import java.util.Objects;
import me.hnguyen.eywa.util.LambdaUtils;
import org.neo4j.ogm.annotation.NodeEntity;
import org.springframework.beans.factory.annotation.Value;

/**
 *
 * @author hnguyen
 */
@NodeEntity(label = "Queue")
public class QueueBeanImpl extends ConfigBeanAbst implements QueueBean {

    @Value("${queue.name}")
    private String name;
    @Value("${queue.durable}")
    private boolean durable;
    @Value("${queue.exclusive}")
    private boolean exclusive;
    @Value("${queue.autoDelete}")
    private boolean autoDelete;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean isDurable() {
        return durable;
    }

    @Override
    public void setDurable(boolean durable) {
        this.durable = durable;
    }

    @Override
    public boolean isExclusive() {
        return exclusive;
    }

    @Override
    public void setExclusive(boolean exclusive) {
        this.exclusive = exclusive;
    }

    @Override
    public boolean isAutoDelete() {
        return autoDelete;
    }

    @Override
    public void setAutoDelete(boolean autoDelete) {
        this.autoDelete = autoDelete;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof SenderChannelBeanImpl)) {
            return false;
        }

        return LambdaUtils.compare_object.apply(this.name, ((QueueBeanImpl) obj).getName());
    }

    @Override
    public int hashCode() {
        int hash = 11;
        hash = 43 * hash + Objects.hashCode(this.name);
        return hash;
    }

}
