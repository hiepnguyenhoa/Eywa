package me.hnguyen.eywa.config.bean;

import me.hnguyen.eywa.amq.service.MessageProcessor;

/**
 *
 * @author hnguyen
 * @param <T> QueueBean
 */
public class ReceiverBeanImpl<T extends QueueBean>
        extends ConfigBeanAbst implements ReceiverBean<T> {

    private T queue;
    private String messageProcessor;

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
    public String getMessageProcessor() {
        return messageProcessor;
    }

    @Override
    public void setMessageProcessor(String MessageProcessor) {
        this.messageProcessor = MessageProcessor;
    }

}
