package me.hnguyen.eywa.config.entity;

import me.hnguyen.eywa.config.bean.ReceiverBean;
import me.hnguyen.eywa.config.dto.ReceiverDto;

/**
 *
 * @author hnguyen
 * @param <T>
 */
public interface ReceiverEntity<T extends QueueEntity>
        extends ReceiverBean<T>, ConfigEntity<ReceiverDto> {
    
}
