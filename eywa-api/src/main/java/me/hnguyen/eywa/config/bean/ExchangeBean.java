package me.hnguyen.eywa.config.bean;

/**
 * @author hnguyen
 */
public interface ExchangeBean extends ConfigBean {

    String EXCHANGE_NAME = "name";
    String EXCHANGE_TYPE = "type";

    void setType(String type);

    String getType();

    boolean isAutoDelete();

    void setAutoDelete(boolean autoDelete);

    boolean isDelay();

    void setDelay(boolean delay);

    boolean isDurable();

    void setDurable(boolean durable);

    boolean isInternal();

    void setInternal(boolean internal);

}
