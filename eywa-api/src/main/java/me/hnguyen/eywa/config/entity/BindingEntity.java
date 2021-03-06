package me.hnguyen.eywa.config.entity;

import me.hnguyen.eywa.config.bean.BindingBean;
import me.hnguyen.eywa.config.dto.BindingDto;

/**
 *
 * @author hnguyen
 * @param <E> ExchangeEntity
 * @param <Q> QueueEntity
 */
public interface BindingEntity<E extends ExchangeEntity, Q extends QueueEntity>
        extends BindingBean<E,Q>, ConfigEntity<BindingDto> {
    
}
