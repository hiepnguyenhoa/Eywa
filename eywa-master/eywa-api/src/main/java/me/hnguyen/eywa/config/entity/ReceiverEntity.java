package me.hnguyen.eywa.config.entity;

import me.hnguyen.eywa.config.bean.ReceiverBean;
import me.hnguyen.eywa.config.dto.ReceiverDto;

/**
 * @param <T> QueueEntity
 * @author hnguyen
 */
public interface ReceiverEntity<T extends QueueEntity> extends ReceiverBean<T>, ConfigEntity<ReceiverDto> {

}
