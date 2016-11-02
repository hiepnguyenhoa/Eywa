package me.hnguyen.eywa.config.entity;

import org.neo4j.ogm.annotation.NodeEntity;

import me.hnguyen.eywa.config.bean.ReceiverBeanImpl;
import me.hnguyen.eywa.config.dto.ReceiverDto;
import me.hnguyen.eywa.config.dto.ReceiverDtoImpl;

/**
 * @author hnguyen
 */
@NodeEntity(label = "Receiver")
public class ReceiverEntityImpl<T extends QueueEntity>
    extends ReceiverBeanImpl<T>
    implements ReceiverEntity<T> {

    /**
     * The method was implemented weirdly because of NEO4J bug with Collection of Generic.
     */
    @Override
    public ReceiverDto toDto() {
        ReceiverDto receiverDto = new ReceiverDtoImpl();
        receiverDto.setKey(this.getKey());
        receiverDto.setName(this.getName());
        receiverDto.setQueue(this.getQueue().toDto());
        receiverDto.setMessageProcessor(this.getMessageProcessor());
        return receiverDto;
    }

}
