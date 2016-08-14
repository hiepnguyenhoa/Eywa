package me.hnguyen.eywa.config.entity;

import me.hnguyen.eywa.config.bean.ReceiverBeanImpl;
import me.hnguyen.eywa.config.dto.ReceiverDtoImpl;
import org.neo4j.ogm.annotation.NodeEntity;
import me.hnguyen.eywa.config.dto.ReceiverDto;
import org.springframework.stereotype.Component;

/**
 *
 * @author hnguyen
 * @param <T>
 */
@NodeEntity(label = "Receiver")
public class ReceiverEntityImpl<T extends QueueEntity>
        extends ReceiverBeanImpl<T>
        implements ReceiverEntity<T> {

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
        receiverDto.setQueue(this.getQueue().toDto());
        return receiverDto;
    }

}
