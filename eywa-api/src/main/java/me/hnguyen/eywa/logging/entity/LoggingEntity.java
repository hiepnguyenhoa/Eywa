package me.hnguyen.eywa.logging.entity;

import me.hnguyen.eywa.BaseEntity;
import me.hnguyen.eywa.logging.bean.LoggingBean;
import me.hnguyen.eywa.logging.dto.LoggingDto;

/**
 * @author hnguyen
 * @param <T>
 */
public interface LoggingEntity<T extends LoggingDto> extends LoggingBean, BaseEntity<T> {

}
