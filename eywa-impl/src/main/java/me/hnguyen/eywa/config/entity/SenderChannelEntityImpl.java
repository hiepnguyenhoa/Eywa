package me.hnguyen.eywa.config.entity;

import me.hnguyen.eywa.config.bean.SenderChannelBeanImpl;
import me.hnguyen.eywa.config.dto.ExchangeDto;
import me.hnguyen.eywa.config.dto.ExchangeDtoImpl;
import me.hnguyen.eywa.config.dto.SenderChannelDtoImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import me.hnguyen.eywa.config.dto.SenderChannelDto;
import me.hnguyen.eywa.util.EywaBeanUtils;
import org.neo4j.ogm.annotation.NodeEntity;

/**
 *
 * @author hnguyen
 */

@NodeEntity(label = "SenderChannel")
public class SenderChannelEntityImpl
        extends SenderChannelBeanImpl<ExchangeEntity>
        implements SenderChannelEntity<ExchangeEntity> {
    
    @Override
    public SenderChannelDto toDto() {
        SenderChannelDto senderChannelDto = new SenderChannelDtoImpl();
        ExchangeDto exchangeDto = new ExchangeDtoImpl();
        exchangeDto = (ExchangeDto) EywaBeanUtils.copyProperties(this.getExchange(), exchangeDto);
        senderChannelDto.setExchange(exchangeDto);
        return senderChannelDto;
    }

}
