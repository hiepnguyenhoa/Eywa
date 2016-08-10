package me.hnguyen.eywa.config.entity;

import java.util.ArrayList;
import java.util.List;
import me.hnguyen.eywa.config.bean.BindingBean;
import me.hnguyen.eywa.config.bean.ReceiverBeanImpl;
import me.hnguyen.eywa.config.dto.BindingDto;
import me.hnguyen.eywa.config.dto.BindingDtoImpl;
import me.hnguyen.eywa.config.dto.ReceiverDtoImpl;
import me.hnguyen.eywa.util.EywaBeanUtils;
import org.neo4j.ogm.annotation.NodeEntity;
import me.hnguyen.eywa.config.dto.ReceiverDto;
import org.springframework.stereotype.Component;

/**
 *
 * @author hnguyen
 * @param <B>
 */
@Component
@NodeEntity(label = "Receiver")
public class ReceiverEntityImpl<B extends BindingEntity>
        extends ReceiverBeanImpl<B>
        implements ReceiverEntity<B> {

    /**
     * The method was implemented weirdly because of NEO4J bug with Collection of Generic.
     * 
     * @return 
     */
    @Override
    public ReceiverDto toDto() {
        ReceiverDto receiverChannelDto = new ReceiverDtoImpl();
        EywaBeanUtils.copyProperties(this, receiverChannelDto);
        List<BindingDto> bindingDtos = new ArrayList<>();
        for(BindingBean bindingBean:this.getBindings()){
            BindingDto bindingDto = new BindingDtoImpl();
            EywaBeanUtils.copyProperties(bindingBean, bindingDto);
            bindingDtos.add(bindingDto);
        }
        receiverChannelDto.setBindings(bindingDtos);
        return receiverChannelDto;
    }

}
