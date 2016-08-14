package me.hnguyen.eywa.config.bean;

/**
 *
 * @author hnguyen
 */
public interface ExchangeBean extends ConfigBean {

    public static final String EXCHANGE_NAME = "name";
    public static final String EXCHANGE_TYPE = "type";

    public void setType(String type);

    public String getType();
    
    public boolean isAutoDelete();

    public void setAutoDelete(boolean autoDelete);

    public boolean isDelay();

    public void setDelay(boolean delay);

    public boolean isDurable();

    public void setDurable(boolean durable);

    public boolean isInternal();

    public void setInternal(boolean internal);

}
