package me.hnguyen.eywa.config.bean;

import org.neo4j.ogm.annotation.NodeEntity;
import org.springframework.beans.factory.annotation.Value;

/**
 *
 * @author hnguyen
 */
@NodeEntity(label = "Queue")
public class QueueBeanImpl extends ConfigBeanAbst implements QueueBean {

    @Value("${queue.durable}")
    private boolean durable;
    @Value("${queue.exclusive}")
    private boolean exclusive;
    @Value("${queue.autoDelete}")
    private boolean autoDelete;

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

}
