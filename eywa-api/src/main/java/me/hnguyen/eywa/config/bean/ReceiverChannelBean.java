package me.hnguyen.eywa.config.bean;

import java.util.List;

/**
 *
 * @author hnguyen
 * @param <B> Binding
 */
public interface ReceiverChannelBean<B extends BindingBean> extends ConfigBean {

    public String getName();

    public void setName(String name);

    public void setBindings(List<B> bindings);

    public List<B> getBindings();

    public void addBinding(B b);

}
