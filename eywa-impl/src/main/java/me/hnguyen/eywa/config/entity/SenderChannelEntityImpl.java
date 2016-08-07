package me.hnguyen.eywa.config.entity;

import me.hnguyen.eywa.config.bean.SenderChannelBeanImpl;
import me.hnguyen.eywa.config.dto.ExchangeDto;
import me.hnguyen.eywa.config.dto.ExchangeDtoImpl;
import me.hnguyen.eywa.config.dto.SenderChannelDtoImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import me.hnguyen.eywa.config.dto.SenderChannelDto;

/**
 *
 * @author hnguyen
 */
@Component
public class SenderChannelEntityImpl
        extends SenderChannelBeanImpl<ExchangeEntity>
        implements SenderChannelEntity<ExchangeEntity> {
    
    @Override
    public SenderChannelDto toDto() {
        SenderChannelDto senderChannelDto = new SenderChannelDtoImpl();
        ExchangeDto exchangeDto = new ExchangeDtoImpl();
        BeanUtils.copyProperties(this.getExchange(), exchangeDto);
        senderChannelDto.setExchange(exchangeDto);
        return senderChannelDto;
    }

}
