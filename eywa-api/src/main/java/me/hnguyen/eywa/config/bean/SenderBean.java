package me.hnguyen.eywa.config.bean;

/**
 * @param <E> ExchangeBean
 * @author hnguyen
 */
public interface SenderBean<E extends ExchangeBean> extends ConfigBean {

    String PRODUCER_CHANNEL_NAME = "name";

    void setExchange(E e);

    E getExchange();

    String getRouting();

    void setRouting(String routing);

}
