package me.hnguyen.eywa.config.bean;

/**
 *
 * @author hnguyen
 * @param <E> ExchangeConfig
 * @param <Q> QueueConfig
 */
public interface BindingBean<E extends ExchangeBean, Q extends QueueBean> extends ConfigBean{
    
    public static final String BINDING_RULE = "rule";
    
    public void setExchange(E exchange);
    public E getExchange();
    
    public void setQueue(Q queue);
    public Q getQueue();
    
    public String getRoutingKey();
    public void setRoutingKey(String rule);
}
