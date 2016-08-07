package me.hnguyen.eywa.config.bean;

import java.util.Objects;
import me.hnguyen.eywa.util.LambdaUtils;

/**
 *
 * @author hnguyen
 * @param <E>
 */
public class SenderChannelBeanImpl< E extends ExchangeBean>
        extends ConfigBeanAbst
        implements SenderChannelBean<E> {

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
        if (!(obj instanceof SenderChannelBeanImpl)) {
            return false;
        }

        return LambdaUtils.compare_object.apply(this.key, ((SenderChannelBeanImpl) obj).getKey());
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 43 * hash + Objects.hashCode(this.key);
        return hash;
    }

}
