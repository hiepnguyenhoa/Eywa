package me.hnguyen.eywa.config.entity;

import me.hnguyen.eywa.config.bean.BindingBeanImpl;
import me.hnguyen.eywa.config.dto.BindingDto;
import me.hnguyen.eywa.config.dto.BindingDtoImpl;
import org.neo4j.ogm.annotation.NodeEntity;
import org.springframework.stereotype.Component;

/**
 *
 * @author hnguyen
 * @param <E>
 * @param <Q>
 */
@Component
@NodeEntity(label = "Binding")
public class BindingEntityImpl<E extends ExchangeEntity, Q extends QueueEntity>
        extends BindingBeanImpl<E, Q>
        implements BindingEntity<E, Q> {

    @Override
    public BindingDto toDto() {
        BindingDto bindingDto = new BindingDtoImpl();
        bindingDto.setId(this.getId());
        bindingDto.setKey(this.getKey());
        bindingDto.setName(this.getName());
        bindingDto.setRoutingKey(this.getRoutingKey());
        if (this.getExchange() != null) {
            bindingDto.setExchange(this.getExchange().toDto());
        }
        if (this.getQueue() != null) {
            bindingDto.setQueue(this.getQueue().toDto());
        }
        return bindingDto;
    }

}
