package me.hnguyen.eywa.config.entity;

import me.hnguyen.eywa.config.bean.ExchangeBeanImpl;
import me.hnguyen.eywa.config.dto.ExchangeDto;
import me.hnguyen.eywa.config.dto.ExchangeDtoImpl;
import me.hnguyen.eywa.util.EywaBeanUtils;
import org.neo4j.ogm.annotation.NodeEntity;
import org.springframework.stereotype.Component;

/**
 *
 * @author hnguyen
 */
@Component
@NodeEntity(label = "Exchange")
public class ExchangeEntityImpl extends ExchangeBeanImpl implements ExchangeEntity {

    @Override
    public ExchangeDto toDto() {
        ExchangeDto exchangeDto = new ExchangeDtoImpl();
        EywaBeanUtils.copyProperties(this, exchangeDto);
        return exchangeDto;

    }

}
