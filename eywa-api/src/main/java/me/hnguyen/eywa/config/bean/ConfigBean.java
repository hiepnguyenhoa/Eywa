package me.hnguyen.eywa.config.bean;

import me.hnguyen.eywa.BaseBean;

/**
 * @author hnguyen
 */
public interface ConfigBean extends BaseBean {

    String KEY = "key";
    String NAME = "name";

    String getKey();

    void setKey(String key);

    String getName();

    void setName(String name);

    String getKeyMap();
}
