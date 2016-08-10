package me.hnguyen.eywa.config.bean;

/**
 *
 * @author hnguyen
 * @param <E> ExchangeConfig
 */
public interface SenderBean<E extends ExchangeBean> extends ConfigBean {

    public static final String PRODUCER_CHANNEL_NAME = "name";

    public void setExchange(E e);

    public E getExchange();

}
