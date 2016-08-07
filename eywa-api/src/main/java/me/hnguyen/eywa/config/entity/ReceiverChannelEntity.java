package me.hnguyen.eywa.config.entity;

import me.hnguyen.eywa.BaseEntity;
import me.hnguyen.eywa.config.bean.ReceiverChannelBean;
import me.hnguyen.eywa.config.dto.ReceiverChannelDto;

/**
 *
 * @author hnguyen
 */
public interface ReceiverChannelEntity<B extends BindingEntity>
        extends ReceiverChannelBean<B>, ConfigEntity<ReceiverChannelDto> {
    
}
