package me.hnguyen.eywa;

/**
 * @author hnguyen
 */
public interface BaseDto<T extends BaseEntity> {

    T toEntity();

}
