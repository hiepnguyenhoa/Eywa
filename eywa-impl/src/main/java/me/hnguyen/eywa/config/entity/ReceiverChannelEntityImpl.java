package me.hnguyen.eywa.config.entity;

import java.util.ArrayList;
import java.util.List;
import me.hnguyen.eywa.config.bean.ReceiverChannelBeanImpl;
import me.hnguyen.eywa.config.dto.BindingDto;
import me.hnguyen.eywa.config.dto.BindingDtoImpl;
import me.hnguyen.eywa.config.dto.ReceiverChannelDtoImpl;
import me.hnguyen.eywa.config.dto.ReceiverChannelDto;
import me.hnguyen.eywa.util.EywaBeanUtils;
import org.neo4j.ogm.annotation.NodeEntity;

/**
 *
 * @author hnguyen
 */
@NodeEntity(label = "ReceiverChannel")
public class ReceiverChannelEntityImpl
        extends ReceiverChannelBeanImpl<BindingEntity>
        implements ReceiverChannelEntity<BindingEntity> {

    @Override
    public ReceiverChannelDto toDto() {
        ReceiverChannelDto receiverChannelDto = new ReceiverChannelDtoImpl();
        EywaBeanUtils.copyProperties(this, receiverChannelDto);
        List<BindingDto> bindingDtos = EywaBeanUtils.toDto(this.getBindings());
        receiverChannelDto.setBindings(bindingDtos);
        return receiverChannelDto;
    }

}
