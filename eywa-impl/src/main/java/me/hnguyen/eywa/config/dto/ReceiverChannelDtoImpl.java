package me.hnguyen.eywa.config.dto;

import me.hnguyen.eywa.config.bean.ReceiverChannelBeanImpl;
import me.hnguyen.eywa.config.entity.ReceiverChannelEntity;

/**
 *
 * @author hnguyen
 */
public class ReceiverChannelDtoImpl
        extends ReceiverChannelBeanImpl<BindingDto>
        implements ReceiverChannelDto<BindingDto> {

    @Override
    public ReceiverChannelEntity toEntity() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
