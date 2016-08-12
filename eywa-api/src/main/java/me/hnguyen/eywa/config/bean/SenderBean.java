package me.hnguyen.eywa.config.bean;

/**
 *
 * @author hnguyen
 * @param <H> HostBean
 * @param <E> ExchangeBean
 */
public interface SenderBean<H extends HostBean, E extends ExchangeBean> extends ConfigBean {

    public static final String PRODUCER_CHANNEL_NAME = "name";
    
    public void setHost(H host);
    
    public H getHost();

    public void setExchange(E e);

    public E getExchange();

    public String getRouting();
    
    public void setRouting(String routing);

}
