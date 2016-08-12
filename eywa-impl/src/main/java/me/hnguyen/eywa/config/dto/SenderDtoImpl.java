package me.hnguyen.eywa.config.dto;

import me.hnguyen.eywa.config.bean.SenderBeanImpl;
import me.hnguyen.eywa.config.entity.SenderEntity;

/**
 *
 * @author hnguyen
 */
public class SenderDtoImpl
        extends SenderBeanImpl<HostDto, ExchangeDto>
        implements SenderDto<HostDto, ExchangeDto> {

    @Override
    public SenderEntity toEntity() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
