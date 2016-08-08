package me.hnguyen.eywa.config.entity;

import me.hnguyen.eywa.config.bean.BindingBeanImpl;
import me.hnguyen.eywa.config.dto.BindingDto;
import me.hnguyen.eywa.config.dto.BindingDtoImpl;
import me.hnguyen.eywa.util.EywaBeanUtils;
import org.neo4j.ogm.annotation.NodeEntity;

/**
 *
 * @author hnguyen
 */

@NodeEntity(label = "Binding")
public class BindingEntityImpl
        extends BindingBeanImpl<ExchangeEntity, QueueEntity>
        implements BindingEntity<ExchangeEntity, QueueEntity> {

    @Override
    public BindingDto toDto() {
        BindingDto bindingDto = new BindingDtoImpl();
        EywaBeanUtils.copyProperties(this, bindingDto);
        return bindingDto;
    }

}
