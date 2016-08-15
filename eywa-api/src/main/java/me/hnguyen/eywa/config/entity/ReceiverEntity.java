package me.hnguyen.eywa.config.entity;

import me.hnguyen.eywa.amq.service.MessageProcessor;
import me.hnguyen.eywa.config.bean.ReceiverBean;
import me.hnguyen.eywa.config.dto.ReceiverDto;

/**
 *
 * @author hnguyen
 * @param <T> QueueEntity
 * @param <M> MessageProcessor
 */
public interface ReceiverEntity<T extends QueueEntity, M extends MessageProcessor> extends ReceiverBean<T, M>, ConfigEntity<ReceiverDto> {
    
}
