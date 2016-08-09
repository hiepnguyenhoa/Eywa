package me.hnguyen.eywa.config.dto;

import me.hnguyen.eywa.config.bean.BindingBean;
import me.hnguyen.eywa.config.entity.BindingEntity;

/**
 *
 * @author hnguyen
 * @param <E> Exchange
 * @param <Q> Queue
 */
public interface BindingDto<E extends ExchangeDto, Q extends QueueDto>
        extends BindingBean<E,Q>, ConfigDto<BindingEntity> {
    
}
