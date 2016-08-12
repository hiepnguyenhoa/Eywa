package me.hnguyen.eywa.config.dto;

import me.hnguyen.eywa.config.bean.ReceiverBeanImpl;
import me.hnguyen.eywa.config.entity.ReceiverEntity;

/**
 *
 * @author hnguyen
 * @param <H> HostDto
 * @param <T> QueueDto
 */
public class ReceiverDtoImpl<H extends HostDto, T extends QueueDto>
        extends ReceiverBeanImpl<H, T>
        implements ReceiverDto<H, T> {

    @Override
    public ReceiverEntity toEntity() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
