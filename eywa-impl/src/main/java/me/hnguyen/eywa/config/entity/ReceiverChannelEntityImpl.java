package me.hnguyen.eywa.config.entity;

import me.hnguyen.eywa.config.bean.ReceiverChannelBeanImpl;
import me.hnguyen.eywa.config.dto.ReceiverChannelDtoImpl;
import org.springframework.beans.BeanUtils;
import me.hnguyen.eywa.config.dto.ReceiverChannelDto;

/**
 *
 * @author hnguyen
 */
public class ReceiverChannelEntityImpl
        extends ReceiverChannelBeanImpl<BindingEntity>
        implements ReceiverChannelEntity<BindingEntity> {

    @Override
    public ReceiverChannelDto toDto() {
        ReceiverChannelDto receiverChannelDto = new ReceiverChannelDtoImpl();
        BeanUtils.copyProperties(this, receiverChannelDto);
        return receiverChannelDto;
    }

}
