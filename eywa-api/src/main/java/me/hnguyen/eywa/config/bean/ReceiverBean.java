package me.hnguyen.eywa.config.bean;

/**
 *
 * @author hnguyen
 * @param <H> HostBean
 * @param <Q> QueueBean
 */
public interface ReceiverBean<H extends HostBean, Q extends QueueBean> extends ConfigBean {

    public void setHost(H host);

    public H getHost();

    public QueueBean getQueue();

    public void setQueue(Q queue);

}
