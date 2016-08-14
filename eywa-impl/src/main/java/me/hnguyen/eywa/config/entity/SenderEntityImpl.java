package me.hnguyen.eywa.config.entity;

import me.hnguyen.eywa.config.bean.SenderBeanImpl;
import me.hnguyen.eywa.config.dto.ExchangeDto;
import me.hnguyen.eywa.config.dto.ExchangeDtoImpl;
import me.hnguyen.eywa.config.dto.SenderDtoImpl;
import me.hnguyen.eywa.util.EywaBeanUtils;
import org.neo4j.ogm.annotation.NodeEntity;
import me.hnguyen.eywa.config.dto.SenderDto;

/**
 *
 * @author hnguyen
 */
@NodeEntity(label = "Sender")
public class SenderEntityImpl
        extends SenderBeanImpl<ExchangeEntity>
        implements SenderEntity<ExchangeEntity> {
    
    @Override
    public SenderDto toDto() {
        SenderDto senderDto = new SenderDtoImpl();
        senderDto.setKey(this.getKey());
        senderDto.setName(this.getName());
        senderDto.setRouting(this.getRouting());
        
        ExchangeDto exchangeDto = new ExchangeDtoImpl();
        exchangeDto = (ExchangeDto) EywaBeanUtils.copyProperties(this.getExchange(), exchangeDto);
        senderDto.setExchange(exchangeDto);
        
        return senderDto;
    }

}
