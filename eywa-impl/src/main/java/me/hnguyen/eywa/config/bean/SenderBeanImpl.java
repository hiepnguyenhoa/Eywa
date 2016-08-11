package me.hnguyen.eywa.config.bean;

import java.util.Objects;
import me.hnguyen.eywa.util.LambdaUtils;
import org.neo4j.ogm.annotation.NodeEntity;

/**
 *
 * @author hnguyen
 * @param <E>
 */
@NodeEntity
public class SenderBeanImpl< E extends ExchangeBean>
        extends ConfigBeanAbst
        implements SenderBean<E> {

    private E exchange;

    @Override
    public E getExchange() {
        return exchange;
    }

    @Override
    public void setExchange(E exchange) {
        this.exchange = exchange;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof SenderBeanImpl)) {
            return false;
        }

        return LambdaUtils.compare_object.apply(this.key, ((SenderBeanImpl) obj).getKey());
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 43 * hash + Objects.hashCode(this.key);
        return hash;
    }

}
