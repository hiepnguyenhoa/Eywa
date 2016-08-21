package me.hnguyen.eywa.config.dto;

import me.hnguyen.eywa.config.bean.ReceiverBean;
import me.hnguyen.eywa.config.entity.ReceiverEntity;

/**
 * @param <B> QueueDto
 * @author hnguyen
 */
public interface ReceiverDto<B extends QueueDto>
        extends ReceiverBean<B>, ConfigDto<ReceiverEntity> {

}
