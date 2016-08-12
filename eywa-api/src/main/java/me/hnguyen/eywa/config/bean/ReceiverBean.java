package me.hnguyen.eywa.config.bean;

import java.util.List;

/**
 *
 * @author hnguyen
 * @param <H> HostBean
 * @param <Q> QueueBean
 */
public interface ReceiverBean<H extends HostBean, Q extends QueueBean> extends ConfigBean {
    
    public void setHost(H host);
    
    public H getHost();

    public void setQueues(List<QueueBean> queues);

    public List<QueueBean> getQueues();

    public QueueBean getQueue(String name);

    public void addQueue(QueueBean queue);

    public QueueBean removeQueue(String name);

}
