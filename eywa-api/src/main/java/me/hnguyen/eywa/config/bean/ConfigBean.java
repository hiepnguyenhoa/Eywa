package me.hnguyen.eywa.config.bean;

import me.hnguyen.eywa.BaseBean;

/**
 *
 * @author hnguyen
 */
public interface ConfigBean extends BaseBean {

    public static final String KEY = "key";
    public static final String NAME = "name";

    public String getKey();

    public void setKey(String key);

    public String getName();

    public void setName(String name);
    
    public String getKeyMap();
}
