package me.hnguyen.eywa;

/**
 * @author hnguyen
 */
public interface BaseEntity<T extends BaseDto> {

    T toDto();

}
