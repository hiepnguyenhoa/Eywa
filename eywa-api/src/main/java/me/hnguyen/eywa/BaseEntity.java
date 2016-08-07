package me.hnguyen.eywa;

/**
 *
 * @author hnguyen
 */
public interface BaseEntity<T extends BaseDto> {
    
    public T toDto();
    
}
