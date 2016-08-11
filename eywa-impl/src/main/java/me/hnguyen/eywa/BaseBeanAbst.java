package me.hnguyen.eywa;

import org.neo4j.ogm.annotation.GraphId;

/**
 *
 * @author hnguyen
 */
public abstract class BaseBeanAbst implements BaseBean{
    
    @GraphId
    protected Long id;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }
    
    @Override
    public abstract boolean equals(Object obj);

    @Override
    public abstract int hashCode();
    
}
