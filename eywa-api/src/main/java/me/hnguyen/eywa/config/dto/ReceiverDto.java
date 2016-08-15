package me.hnguyen.eywa.config.dto;

import me.hnguyen.eywa.amq.service.MessageProcessor;
import me.hnguyen.eywa.config.bean.ReceiverBean;
import me.hnguyen.eywa.config.entity.ReceiverEntity;

/**
 *
 * @author hnguyen
 * @param <B> QueueDto
 * @param <M>
 */
public interface ReceiverDto<B extends QueueDto, M extends MessageProcessor> 
        extends ReceiverBean<B, M>, ConfigDto<ReceiverEntity> {
    
}
