package me.hnguyen.eywa.config.bean;

import java.util.Objects;
import me.hnguyen.eywa.util.LambdaUtils;
import org.springframework.beans.factory.annotation.Value;

/**
 *
 * @author hnguyen
 * @param <E>
 * @param <Q>
 */
public class BindingBeanImpl< E extends ExchangeBean, Q extends QueueBean>
        extends ConfigBeanAbst
        implements BindingBean<E, Q> {

    private E exchange;

    private Q queue;

    @Value("${binding.routingKey}")
    private String routingKey;

    @Override
    public E getExchange() {
        return exchange;
    }

    @Override
    public void setExchange(E exchange) {
        this.exchange = exchange;
    }

    @Override
    public Q getQueue() {
        return queue;
    }

    @Override
    public void setQueue(Q queue) {
        this.queue = queue;
    }

    @Override
    public String getRoutingKey() {
        return routingKey;
    }

    @Override
    public void setRoutingKey(String routingKey) {
        this.routingKey = routingKey;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof BindingBeanImpl)) {
            return false;
        }
        BindingBeanImpl binding = (BindingBeanImpl) obj;
        return LambdaUtils.compare_object.apply(this.exchange, binding.exchange)
                || LambdaUtils.compare_object.apply(this.queue, binding.queue)
                || LambdaUtils.compare_object.apply(this.routingKey, binding.routingKey);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.exchange);
        hash = 37 * hash + Objects.hashCode(this.queue);
        hash = 37 * hash + Objects.hashCode(this.routingKey);
        return hash;
    }
    
    @Override
    public String getKeyMap() {
        StringBuilder keyMap = new StringBuilder();
        keyMap.append(this.getKey()).append("_").append(this.getName());
        return keyMap.toString();
    }

}
