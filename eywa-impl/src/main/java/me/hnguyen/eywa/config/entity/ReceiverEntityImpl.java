package me.hnguyen.eywa.config.entity;

import java.util.List;
import me.hnguyen.eywa.config.bean.ReceiverBeanImpl;
import me.hnguyen.eywa.config.dto.ReceiverDtoImpl;
import me.hnguyen.eywa.util.EywaBeanUtils;
import org.neo4j.ogm.annotation.NodeEntity;
import me.hnguyen.eywa.config.dto.ReceiverDto;
import org.springframework.stereotype.Component;

/**
 *
 * @author hnguyen
 * @param <H>
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
        ReceiverDto receiverDto = new ReceiverDtoImpl();
        receiverDto.setKey(this.getKey());
        receiverDto.setName(this.getName());
        receiverDto.setHost(this.getHost().toDto());
        receiverDto.setQueue(this.getQueue().toDto());
        return receiverDto;
    }

}
