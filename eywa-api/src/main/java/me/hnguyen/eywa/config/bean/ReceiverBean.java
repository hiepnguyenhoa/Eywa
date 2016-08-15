package me.hnguyen.eywa.config.bean;

import me.hnguyen.eywa.amq.service.MessageProcessor;

/**
 *
 * @author hnguyen
 * @param <Q> QueueBean
 * @param <M> MessageProcessor
 */
public interface ReceiverBean<Q extends QueueBean, M extends MessageProcessor> extends ConfigBean {

    public Q getQueue();

    public void setQueue(Q queue);
    
    public M getMessageProcessor();
    
    public void setMessageProcessor(M messageProcessor);

}
