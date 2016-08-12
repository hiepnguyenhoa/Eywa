package me.hnguyen.eywa.config.entity;

import me.hnguyen.eywa.config.bean.ReceiverBeanImpl;
import me.hnguyen.eywa.config.dto.ReceiverDtoImpl;
import me.hnguyen.eywa.util.EywaBeanUtils;
import org.neo4j.ogm.annotation.NodeEntity;
import me.hnguyen.eywa.config.dto.ReceiverDto;
import org.springframework.stereotype.Component;

/**
 *
 * @author hnguyen
 * @param <T>
 */
@Component
@NodeEntity(label = "Receiver")
public class ReceiverEntityImpl<H extends HostEntity, T extends QueueEntity>
        extends ReceiverBeanImpl<H, T>
        implements ReceiverEntity<H, T> {

    /**
     * The method was implemented weirdly because of NEO4J bug with Collection of Generic.
     * 
     * @return 
     */
    @Override
    public ReceiverDto toDto() {
        ReceiverDto receiverChannelDto = new ReceiverDtoImpl();
        EywaBeanUtils.copyProperties(this, receiverChannelDto);
//        List<QueueDto> queueDtos = EywaBeanUtils.toDto(this.getQueues());
//        receiverChannelDto.setQueues(queueDtos);
        return receiverChannelDto;
    }

}
