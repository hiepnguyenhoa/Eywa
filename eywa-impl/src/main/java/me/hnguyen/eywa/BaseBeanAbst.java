package me.hnguyen.eywa;

/**
 *
 * @author hnguyen
 */
public abstract class BaseBeanAbst implements BaseBean{
    
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
