package me.hnguyen.eywa.config.dto;

import me.hnguyen.eywa.config.bean.BindingBeanImpl;
import me.hnguyen.eywa.config.entity.BindingEntity;

/**
 * @author hnguyen
 */
public class BindingDtoImpl
    extends BindingBeanImpl<ExchangeDto, QueueDto>
    implements BindingDto<ExchangeDto, QueueDto> {

    @Override
    public BindingEntity toEntity() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
