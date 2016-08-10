package me.hnguyen.eywa.config.bean;

import java.util.List;

/**
 *
 * @author hnguyen
 * @param <B> Binding
 */
public interface ReceiverBean<B extends BindingBean> extends ConfigBean {

    public void setBindings(List<BindingBean> bindings);

    public List<BindingBean> getBindings();

    public void addBinding(B b);

}
