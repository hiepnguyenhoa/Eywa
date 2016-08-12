package me.hnguyen.eywa.amq.service;

/**
 *
 * @author hnguyen
 */
public interface EywaReceiver<T> {

    public void process(T message);
}
