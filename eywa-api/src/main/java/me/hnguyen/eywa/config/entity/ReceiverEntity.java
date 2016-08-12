package me.hnguyen.eywa.config.entity;

import me.hnguyen.eywa.config.bean.ReceiverBean;
import me.hnguyen.eywa.config.dto.ReceiverDto;

/**
 *
 * @author hnguyen
 * @param <H> HostEntity
 * @param <T> QueueEntity
 */
public interface ReceiverEntity<H extends HostEntity, T extends QueueEntity>
        extends ReceiverBean<H, T>, ConfigEntity<ReceiverDto> {
    
}
