package me.hnguyen.eywa.config.dto;

import me.hnguyen.eywa.BaseDto;
import me.hnguyen.eywa.config.bean.ReceiverChannelBean;
import me.hnguyen.eywa.config.entity.ReceiverChannelEntity;

/**
 *
 * @author hnguyen
 */
public interface ReceiverChannelDto<B extends BindingDto> 
        extends ReceiverChannelBean<B>, ConfigDto<ReceiverChannelEntity> {
    
}
