package me.hnguyen.eywa.config.entity;

import me.hnguyen.eywa.BaseEntity;
import me.hnguyen.eywa.config.bean.BindingBean;
import me.hnguyen.eywa.config.dto.BindingDto;

/**
 *
 * @author hnguyen
 */
public interface BindingEntity<E extends ExchangeEntity, Q extends QueueEntity>
        extends BindingBean<E,Q>, ConfigEntity<BindingDto> {
    
}
