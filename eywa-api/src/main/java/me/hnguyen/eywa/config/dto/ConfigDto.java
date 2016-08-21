package me.hnguyen.eywa.config.dto;

import me.hnguyen.eywa.BaseDto;
import me.hnguyen.eywa.config.bean.ConfigBean;
import me.hnguyen.eywa.config.entity.ConfigEntity;

/**
 * @param <T> ConfigEntity
 * @author hnguyen
 */
public interface ConfigDto<T extends ConfigEntity> extends ConfigBean, BaseDto<T> {

}
