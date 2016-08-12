package me.hnguyen.eywa.config.bean;

import java.util.ArrayList;
import java.util.List;
import org.neo4j.ogm.annotation.NodeEntity;

/**
 *
 * @author hnguyen
 * @param <H> HostBean
 * @param <T> QueueBean
 */
@NodeEntity
public class ReceiverBeanImpl<H extends HostBean, T extends QueueBean> extends ConfigBeanAbst implements ReceiverBean<H, T> {

    /**
     * due to a bug in Neo4J
     */
    private List<QueueBean> queues = new ArrayList<>();
    
    private H host;

    @Override
    public H getHost() {
        return host;
    }

    @Override
    public void setHost(H host) {
        this.host = host;
    }

    @Override
    public List<QueueBean> getQueues() {
        return (List<QueueBean>) queues;
    }

    @Override
    public void setQueues(List<QueueBean> queues) {
        this.queues = (List<QueueBean>) queues;
    }

    @Override
    public QueueBean getQueue(String name) {
        for(QueueBean queue:queues){
            if(queue.getName().equals(name)){
                return queue;
            }
        }
        return null;
    }

    @Override
    public void addQueue(QueueBean queue) {
        this.queues.add(queue);
    }

    @Override
    public QueueBean removeQueue(String name) {
        throw new UnsupportedOperationException();
    }

}
