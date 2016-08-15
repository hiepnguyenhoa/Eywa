package me.hnguyen.eywa.config.bean;

import me.hnguyen.eywa.amq.service.MessageProcessor;

/**
 *
 * @author hnguyen
 * @param <T> QueueBean
 * @param <M>
 */
public class ReceiverBeanImpl<T extends QueueBean, M extends MessageProcessor>
        extends ConfigBeanAbst implements ReceiverBean<T, M> {

    private T queue;
    private M messageProcessor;

    @Override
    public T getQueue() {
        return queue;
    }

    @Override
    public void setQueue(T queue) {
        this.queue = queue;
    }

    @Override
    public String getKeyMap() {
        StringBuilder keyMap = new StringBuilder();
        keyMap.append(this.getKey()).append("_").append(this.getName());
        return keyMap.toString();
    }

    @Override
    public M getMessageProcessor() {
        return messageProcessor;
    }

    @Override
    public void setMessageProcessor(M MessageProcessor) {
        this.messageProcessor = MessageProcessor;
    }

}
