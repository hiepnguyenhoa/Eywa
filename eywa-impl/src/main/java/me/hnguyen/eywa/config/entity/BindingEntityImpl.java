package me.hnguyen.eywa.config.entity;

import me.hnguyen.eywa.config.bean.BindingBeanImpl;
import me.hnguyen.eywa.config.dto.BindingDto;
import me.hnguyen.eywa.config.dto.BindingDtoImpl;
import org.springframework.beans.BeanUtils;

/**
 *
 * @author hnguyen
 */
public class BindingEntityImpl
        extends BindingBeanImpl<ExchangeEntity, QueueEntity>
        implements BindingEntity<ExchangeEntity, QueueEntity> {

    @Override
    public BindingDto toDto() {
        BindingDto bindingDto = new BindingDtoImpl();
        BeanUtils.copyProperties(this, bindingDto);
        return bindingDto;
    }

}
