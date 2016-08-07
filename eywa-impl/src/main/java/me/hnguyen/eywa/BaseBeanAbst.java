package me.hnguyen.eywa;

/**
 *
 * @author hnguyen
 */
public abstract class BaseBeanAbst implements BaseBean{
    
    protected long id;

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }
    
    @Override
    public abstract boolean equals(Object obj);

    @Override
    public abstract int hashCode();
    
}
