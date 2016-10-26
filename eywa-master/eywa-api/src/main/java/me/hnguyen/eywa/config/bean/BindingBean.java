package me.hnguyen.eywa.config.bean;

/**
 * @param <E> ExchangeConfig
 * @param <Q> QueueConfig
 * @author hnguyen
 */
public interface BindingBean<E extends ExchangeBean, Q extends QueueBean> extends ConfigBean {

    String BINDING_RULE = "rule";

    void setExchange(E exchange);

    E getExchange();

    void setQueue(Q queue);

    Q getQueue();

    String getRouting();

    void setRouting(String rule);
}
