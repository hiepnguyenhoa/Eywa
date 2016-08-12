package me.hnguyen.eywa.config.entity;

import me.hnguyen.eywa.config.bean.SenderBeanImpl;
import me.hnguyen.eywa.config.dto.ExchangeDto;
import me.hnguyen.eywa.config.dto.ExchangeDtoImpl;
import me.hnguyen.eywa.config.dto.SenderDtoImpl;
import me.hnguyen.eywa.util.EywaBeanUtils;
import org.neo4j.ogm.annotation.NodeEntity;
import me.hnguyen.eywa.config.dto.SenderDto;
import org.springframework.stereotype.Component;

/**
 *
 * @author hnguyen
 */
@Component
@NodeEntity(label = "Sender")
public class SenderEntityImpl
        extends SenderBeanImpl<HostEntity, ExchangeEntity>
        implements SenderEntity<HostEntity, ExchangeEntity> {
    
    @Override
    public SenderDto toDto() {
        SenderDto senderChannelDto = new SenderDtoImpl();
        ExchangeDto exchangeDto = new ExchangeDtoImpl();
        exchangeDto = (ExchangeDto) EywaBeanUtils.copyProperties(this.getExchange(), exchangeDto);
        senderChannelDto.setExchange(exchangeDto);
        return senderChannelDto;
    }

}
