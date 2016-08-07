package me.hnguyen.eywa.config.dto;

import me.hnguyen.eywa.config.bean.SenderChannelBeanImpl;
import me.hnguyen.eywa.config.entity.SenderChannelEntity;

/**
 *
 * @author hnguyen
 */
public class SenderChannelDtoImpl
        extends SenderChannelBeanImpl<ExchangeDto>
        implements SenderChannelDto<ExchangeDto> {

    @Override
    public SenderChannelEntity toEntity() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
