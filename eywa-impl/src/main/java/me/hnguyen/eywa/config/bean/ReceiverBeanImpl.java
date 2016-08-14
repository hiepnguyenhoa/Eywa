package me.hnguyen.eywa.config.bean;

/**
 *
 * @author hnguyen
 * @param <T> QueueBean
 */
public class ReceiverBeanImpl<T extends QueueBean> extends ConfigBeanAbst implements ReceiverBean<T> {

    private T queue;

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

}
