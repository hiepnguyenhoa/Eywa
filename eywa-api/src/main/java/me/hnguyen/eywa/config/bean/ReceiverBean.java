package me.hnguyen.eywa.config.bean;

import java.util.List;

/**
 *
 * @author hnguyen
 * @param <Q>
 */
public interface ReceiverBean<Q extends QueueBean> extends ConfigBean {

    public void setQueues(List<QueueBean> queues);

    public List<QueueBean> getQueues();

    public QueueBean getQueue(String name);

    public void addQueue(QueueBean queue);

    public QueueBean removeQueue(String name);

}
