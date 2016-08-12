package me.hnguyen.eywa.config.dto;

import me.hnguyen.eywa.config.bean.ReceiverBean;
import me.hnguyen.eywa.config.entity.ReceiverEntity;

/**
 *
 * @author hnguyen
 * @param <H> HostDto
 * @param <B> QueueDto
 */
public interface ReceiverDto<H extends  HostDto, B extends QueueDto> 
        extends ReceiverBean<H, B>, ConfigDto<ReceiverEntity> {
    
}
