package me.hnguyen.eywa.config.bean;

import java.util.Objects;
import org.neo4j.ogm.annotation.NodeEntity;
import org.springframework.beans.factory.annotation.Value;

/**
 *
 * @author hnguyen
 */
@NodeEntity
public class ExchangeBeanImpl extends ConfigBeanAbst implements ExchangeBean {

    @Value("${exchange.type}")
    private String type;

    @Override
    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String getType() {
        return this.type;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof ExchangeBeanImpl)) {
            return false;
        }
        ExchangeBeanImpl tmp = (ExchangeBeanImpl) obj;
        return this.getName().endsWith(tmp.getName());
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.getName());
        return hash;
    }

}
