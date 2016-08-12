package me.hnguyen.eywa.config.entity;

import me.hnguyen.eywa.config.bean.SenderBeanImpl;
import me.hnguyen.eywa.config.dto.ExchangeDto;
import me.hnguyen.eywa.config.dto.ExchangeDtoImpl;
import me.hnguyen.eywa.config.dto.HostDto;
import me.hnguyen.eywa.config.dto.HostDtoImpl;
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
        SenderDto senderDto = new SenderDtoImpl();
        senderDto.setKey(this.getKey());
        senderDto.setName(this.getName());
        senderDto.setRouting(this.getRouting());
        
        ExchangeDto exchangeDto = new ExchangeDtoImpl();
        exchangeDto = (ExchangeDto) EywaBeanUtils.copyProperties(this.getExchange(), exchangeDto);
        senderDto.setExchange(exchangeDto);
        
        HostDto hostDto = new HostDtoImpl();
        hostDto = (HostDto) EywaBeanUtils.copyProperties(this.getHost(), hostDto);
        senderDto.setHost(hostDto);
        
        return senderDto;
    }

}
