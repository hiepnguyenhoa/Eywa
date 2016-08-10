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
@NodeEntity(label = "Receiver")
public class ReceiverBeanImpl<B extends BindingBean> extends ConfigBeanAbst implements ReceiverBean<B> {

    /**
     * due to a bug in Neo4J
     */
    private List<BindingBean> bindings;

    @Override
    public List<BindingBean> getBindings() {
        return bindings;
    }

    @Override
    public void setBindings(List<BindingBean> bindings) {
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
        if(!(obj instanceof ReceiverBeanImpl)){
            return false;
        }
        ReceiverBeanImpl tmp = (ReceiverBeanImpl) obj;
        return LambdaUtils.compare_object.apply(this.name, tmp.name);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.name);
        return hash;
    }

}
