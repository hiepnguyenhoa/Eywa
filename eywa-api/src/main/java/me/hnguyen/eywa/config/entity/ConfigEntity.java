package me.hnguyen.eywa.config.entity;

import me.hnguyen.eywa.BaseEntity;
import me.hnguyen.eywa.config.bean.ConfigBean;
import me.hnguyen.eywa.config.dto.ConfigDto;

/**
 * @param <T>
 * @author hnguyen
 */
public interface ConfigEntity<T extends ConfigDto> extends ConfigBean, BaseEntity<T> {

}
