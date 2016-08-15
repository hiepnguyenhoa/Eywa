package me.hnguyen.eywa.config.entity;

import me.hnguyen.eywa.amq.service.MessageProcessor;
import me.hnguyen.eywa.config.bean.ReceiverBeanImpl;
import me.hnguyen.eywa.config.dto.ReceiverDtoImpl;
import org.neo4j.ogm.annotation.NodeEntity;
import me.hnguyen.eywa.config.dto.ReceiverDto;

/**
 *
 * @author hnguyen
 * @param <T>
 * @param <M>
 */
@NodeEntity(label = "Receiver")
public class ReceiverEntityImpl<T extends QueueEntity,  M extends MessageProcessor>
        extends ReceiverBeanImpl<T, M>
        implements ReceiverEntity<T, M> {

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
        receiverDto.setMessageProcessor(this.getMessageProcessor());
        return receiverDto;
    }

}
