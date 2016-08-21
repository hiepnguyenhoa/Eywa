package me.hnguyen.eywa;

/**
 * @param <T>
 * @author hnguyen
 */
public interface BaseEntity<T extends BaseDto> {

    T toDto();

}
