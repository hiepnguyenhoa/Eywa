package me.hnguyen.eywa.config.entity;

import me.hnguyen.eywa.config.bean.ReceiverBean;
import me.hnguyen.eywa.config.dto.ReceiverDto;

/**
 *
 * @author hnguyen
 * @param <B> BindingEntity
 */
public interface ReceiverEntity<B extends BindingEntity>
        extends ReceiverBean<B>, ConfigEntity<ReceiverDto> {
    
}
