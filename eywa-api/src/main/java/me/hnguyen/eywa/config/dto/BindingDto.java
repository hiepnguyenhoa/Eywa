package me.hnguyen.eywa.config.dto;

import me.hnguyen.eywa.config.bean.BindingBean;
import me.hnguyen.eywa.config.entity.BindingEntity;

/**
 * @param <E> Exchange
 * @param <Q> Queue
 * @author hnguyen
 */
public interface BindingDto<E extends ExchangeDto, Q extends QueueDto>
        extends BindingBean<E, Q>, ConfigDto<BindingEntity> {

}
