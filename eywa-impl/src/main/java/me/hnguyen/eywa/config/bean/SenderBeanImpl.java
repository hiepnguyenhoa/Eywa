package me.hnguyen.eywa.config.bean;

import java.util.Objects;
import me.hnguyen.eywa.util.LambdaUtils;
import org.springframework.beans.factory.annotation.Value;

/**
 *
 * @author hnguyen
 * @param <H>
 * @param <E>
 */
public class SenderBeanImpl<H extends HostBean, E extends ExchangeBean> extends ConfigBeanAbst implements SenderBean<H, E> {

    @Value("${sender.routing}")
    private String routing;
    private E exchange;

    private H host;

    @Override
    public String getRouting() {
        return routing;
    }

    @Override
    public void setRouting(String routing) {
        this.routing = routing;
    }

    @Override
    public H getHost() {
        return host;
    }

    @Override
    public void setHost(H host) {
        this.host = host;
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

}
