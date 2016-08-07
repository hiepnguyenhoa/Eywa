package me.hnguyen.eywa.config.bean;

/**
 *
 * @author hnguyen
 */
public interface QueueBean extends ConfigBean {

    public static final String QUEUE_NAME = "name";
    public static final String DURABLE = "durable";
    public static final String EXCLUSIVE = "exclusive";
    public static final String AUTO_DELETE = "autoDelete";

    public String getName();

    public void setName(String name);

    public void setDurable(boolean isDurable);

    public boolean isDurable();

    public void setExclusive(boolean isExclusive);

    public boolean isExclusive();

    public void setAutoDelete(boolean isAutoDelete);

    public boolean isAutoDelete();

}
