package me.hnguyen.eywa.config.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import me.hnguyen.eywa.util.LambdaUtils;
import org.neo4j.ogm.annotation.NodeEntity;

/**
 *
 * @author hnguyen
 * @param <B>
 */
@NodeEntity(label = "ReceiverChannel")
public class ReceiverChannelBeanImpl<B extends BindingBean> extends ConfigBeanAbst implements ReceiverChannelBean<B> {

    /**
     * due to a bug in Neo4J
     */
    private List<BindingBean> bindings;
    
    private String name;
    
    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public List<B> getBindings() {
        return (List<B>) bindings;
    }

    @Override
    public void setBindings(List<B> bindings) {
        this.bindings = (List<BindingBean>) bindings;
    }

    @Override
    public void addBinding(B b) {
        synchronized (this) {
            if (this.bindings == null) {
                bindings = new ArrayList<>();
            }
        }
        this.bindings.add(b);
    }
    
    @Override
    public boolean equals(Object obj){
        if(obj==null){
            return false;
        }
        if(!(obj instanceof ReceiverChannelBeanImpl)){
            return false;
        }
        ReceiverChannelBeanImpl tmp = (ReceiverChannelBeanImpl) obj;
        return LambdaUtils.compare_object.apply(this.name, tmp.name);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.name);
        return hash;
    }

}
