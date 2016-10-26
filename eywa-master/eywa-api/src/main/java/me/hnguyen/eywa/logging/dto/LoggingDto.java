package me.hnguyen.eywa.logging.dto;

import me.hnguyen.eywa.BaseDto;
import me.hnguyen.eywa.logging.bean.LoggingBean;
import me.hnguyen.eywa.logging.entity.LoggingEntity;

/**
 * @author hnguyen
 */
public interface LoggingDto<T extends LoggingEntity> extends LoggingBean, BaseDto<T> {

}
