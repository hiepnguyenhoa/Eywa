package me.hnguyen.eywa.config.entity;

import me.hnguyen.eywa.config.bean.ExchangeBeanImpl;
import me.hnguyen.eywa.config.dto.ExchangeDto;
import me.hnguyen.eywa.config.dto.ExchangeDtoImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 *
 * @author hnguyen
 */
@Component
public class ExchangeEntityImpl extends ExchangeBeanImpl implements ExchangeEntity {

    @Override
    public ExchangeDto toDto() {
        ExchangeDto exchangeDto = new ExchangeDtoImpl();
        BeanUtils.copyProperties(this, exchangeDto);
        return exchangeDto;

    }

}
