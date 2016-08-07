package me.hnguyen.eywa.config.bean;

/**
 *
 * @author hnguyen
 */
public interface ExchangeBean extends ConfigBean {

    public static final String EXCHANGE_NAME = "name";

    public static final String EXCHANGE_TYPE = "type";

    public void setName(String name);

    public String getName();

    public void setType(String type);

    public String getType();

}
