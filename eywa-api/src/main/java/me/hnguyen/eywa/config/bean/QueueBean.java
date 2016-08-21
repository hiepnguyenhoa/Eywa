package me.hnguyen.eywa.config.bean;

/**
 * @author hnguyen
 */
public interface QueueBean extends ConfigBean {

    String QUEUE_NAME = "name";
    String DURABLE = "durable";
    String EXCLUSIVE = "exclusive";
    String AUTO_DELETE = "autoDelete";

    String getName();

    void setName(String name);

    void setDurable(boolean isDurable);

    boolean isDurable();

    void setExclusive(boolean isExclusive);

    boolean isExclusive();

    void setAutoDelete(boolean isAutoDelete);

    boolean isAutoDelete();

}
