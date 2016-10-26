package me.hnguyen.eywa.config.bean;

/**
 * @author hnguyen
 */
public class ExchangeBeanImpl extends ConfigBeanAbst implements ExchangeBean {

    private String type;
    private boolean autoDelete;
    private boolean delay;
    private boolean durable;
    private boolean internal;

    @Override
    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String getType() {
        return this.type;
    }

    @Override
    public boolean isAutoDelete() {
        return autoDelete;
    }

    @Override
    public void setAutoDelete(boolean autoDelete) {
        this.autoDelete = autoDelete;
    }

    @Override
    public boolean isDelay() {
        return delay;
    }

    @Override
    public void setDelay(boolean delay) {
        this.delay = delay;
    }

    @Override
    public boolean isDurable() {
        return durable;
    }

    @Override
    public void setDurable(boolean durable) {
        this.durable = durable;
    }

    @Override
    public boolean isInternal() {
        return internal;
    }

    @Override
    public void setInternal(boolean internal) {
        this.internal = internal;
    }

    @Override
    public String getKeyMap() {
        StringBuilder keyMap = new StringBuilder();
        keyMap.append(this.getKey()).append("_").append(this.getName());
        return keyMap.toString();
    }

}
