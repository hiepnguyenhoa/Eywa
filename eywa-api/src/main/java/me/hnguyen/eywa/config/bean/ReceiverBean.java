package me.hnguyen.eywa.config.bean;

/**
 *
 * @author hnguyen
 * @param <Q> QueueBean
 */
public interface ReceiverBean<Q extends QueueBean> extends ConfigBean {

    public QueueBean getQueue();

    public void setQueue(Q queue);

}
