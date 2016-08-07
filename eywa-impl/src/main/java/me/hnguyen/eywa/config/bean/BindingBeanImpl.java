package me.hnguyen.eywa.config.bean;

import java.util.Objects;
import me.hnguyen.eywa.util.LambdaUtils;

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

    private String rule;

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
    public String getRule() {
        return rule;
    }

    @Override
    public void setRule(String rule) {
        this.rule = rule;
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
                || LambdaUtils.compare_object.apply(this.rule, binding.rule);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.exchange);
        hash = 37 * hash + Objects.hashCode(this.queue);
        hash = 37 * hash + Objects.hashCode(this.rule);
        return hash;
    }

}
