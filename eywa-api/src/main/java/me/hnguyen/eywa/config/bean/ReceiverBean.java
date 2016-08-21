package me.hnguyen.eywa.config.bean;

/**
 * @param <Q> QueueBean
 * @author hnguyen
 */
public interface ReceiverBean<Q extends QueueBean> extends ConfigBean {

    Q getQueue();

    void setQueue(Q queue);

    String getMessageProcessor();

    void setMessageProcessor(String messageProcessor);

}
