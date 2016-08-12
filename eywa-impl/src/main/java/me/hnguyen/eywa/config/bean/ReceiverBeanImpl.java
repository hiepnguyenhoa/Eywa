package me.hnguyen.eywa.config.bean;

/**
 *
 * @author hnguyen
 * @param <H> HostBean
 * @param <T> QueueBean
 */
public class ReceiverBeanImpl<H extends HostBean, T extends QueueBean> extends ConfigBeanAbst implements ReceiverBean<H, T> {

    private T queue;

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
    public T getQueue() {
        return queue;
    }

    @Override
    public void setQueue(T queue) {
        this.queue = queue;
    }

}
