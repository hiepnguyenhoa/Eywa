package me.hnguyen.eywa.config.bean;

import java.util.Objects;

import me.hnguyen.eywa.util.LambdaUtils;

/**
 * @author hnguyen
 */
public class BindingBeanImpl<E extends ExchangeBean, Q extends QueueBean>
    extends ConfigBeanAbst
    implements BindingBean<E, Q> {

    private E exchange;
    private Q queue;
    private String routing;

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
    public String getRouting() {
        return routing;
    }

    @Override
    public void setRouting(String routingKey) {
        this.routing = routingKey;
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
               || LambdaUtils.compare_object.apply(this.routing, binding.routing);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.exchange);
        hash = 37 * hash + Objects.hashCode(this.queue);
        hash = 37 * hash + Objects.hashCode(this.routing);
        return hash;
    }

    @Override
    public String getKeyMap() {
        StringBuilder keyMap = new StringBuilder();
        keyMap.append(this.getKey()).append("_").append(this.getName());
        return keyMap.toString();
    }

}
