package me.hnguyen.eywa.config.bean;

import java.util.Objects;
import me.hnguyen.eywa.BaseBeanAbst;
import me.hnguyen.eywa.util.LambdaUtils;

/**
 *
 * @author hnguyen
 */
public abstract class ConfigBeanAbst extends BaseBeanAbst implements ConfigBean {

    protected String key;
    protected String name;

    @Override
    public String getKey() {
        return key;
    }

    @Override
    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof ConfigBeanAbst)) {
            return false;
        }

        ConfigBeanAbst tmp = (ConfigBeanAbst) obj;
        return LambdaUtils.compare_object.apply(this.key, tmp.getKey())
                || LambdaUtils.compare_object.apply(this.name, tmp.getName());
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.key);
        hash = 31 * hash + Objects.hashCode(this.name);
        return hash;
    }
}
