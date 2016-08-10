package me.hnguyen.eywa.config.dto;

import me.hnguyen.eywa.BaseDto;
import me.hnguyen.eywa.config.bean.ReceiverBean;
import me.hnguyen.eywa.config.entity.ReceiverEntity;

/**
 *
 * @author hnguyen
 */
public interface ReceiverDto<B extends BindingDto> 
        extends ReceiverBean<B>, ConfigDto<ReceiverEntity> {
    
}
