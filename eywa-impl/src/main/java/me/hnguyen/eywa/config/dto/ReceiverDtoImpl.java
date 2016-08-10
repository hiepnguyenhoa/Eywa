package me.hnguyen.eywa.config.dto;

import me.hnguyen.eywa.config.bean.ReceiverBeanImpl;
import me.hnguyen.eywa.config.entity.ReceiverEntity;

/**
 *
 * @author hnguyen
 * @param <B>
 */
public class ReceiverDtoImpl<B extends BindingDto>
        extends ReceiverBeanImpl<B>
        implements ReceiverDto<B> {

    @Override
    public ReceiverEntity toEntity() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
