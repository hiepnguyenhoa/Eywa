package me.hnguyen.eywa;

/**
 *
 * @author hnguyen
 * @param <T>
 */
public interface BaseEntity<T extends BaseDto> {
    
    public T toDto();
    
}
