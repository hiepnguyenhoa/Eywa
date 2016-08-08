package me.hnguyen.eywa.config.bean;

import me.hnguyen.eywa.BaseBeanAbst;
import org.neo4j.ogm.annotation.NodeEntity;
import org.springframework.beans.factory.annotation.Value;

/**
 *
 * @author hnguyen
 */
@NodeEntity(label = "Config")
public abstract class ConfigBeanAbst extends BaseBeanAbst implements ConfigBean {
    
    @Value("${config.key}")
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
