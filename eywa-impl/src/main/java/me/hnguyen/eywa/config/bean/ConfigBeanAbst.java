package me.hnguyen.eywa.config.bean;

import me.hnguyen.eywa.BaseBeanAbst;

/**
 *
 * @author hnguyen
 */
public abstract class ConfigBeanAbst extends BaseBeanAbst implements ConfigBean {
    
    protected String key;

    @Override
    public String getKey() {
        return key;
    }

    @Override
    public void setKey(String key) {
        this.key = key;
    }
    
}
