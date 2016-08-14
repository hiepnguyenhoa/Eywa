package me.hnguyen.eywa.config.bean;

import java.util.Objects;
import me.hnguyen.eywa.util.LambdaUtils;

/**
 *
 * @author hnguyen
 * @param <E>
 */
public class SenderBeanImpl<E extends ExchangeBean> extends ConfigBeanAbst implements SenderBean<E> {

    private String routing;
    private E exchange;

    @Override
    public String getRouting() {
        return routing;
    }

    @Override
    public void setRouting(String routing) {
        this.routing = routing;
    }

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

    @Override
    public String getKeyMap() {
        StringBuilder keyMap = new StringBuilder();
        keyMap.append(this.getKey()).append("_").append(this.getName());
        return keyMap.toString();
    }

}
