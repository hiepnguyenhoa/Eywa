package me.hnguyen.eywa.config.dto;

import me.hnguyen.eywa.config.bean.ReceiverBeanImpl;
import me.hnguyen.eywa.config.entity.ReceiverEntity;

/**
 *
 * @author hnguyen
 * @param <T> QueueDto
 */
public class ReceiverDtoImpl<T extends QueueDto>
        extends ReceiverBeanImpl<T>
        implements ReceiverDto<T> {

    @Override
    public ReceiverEntity toEntity() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
