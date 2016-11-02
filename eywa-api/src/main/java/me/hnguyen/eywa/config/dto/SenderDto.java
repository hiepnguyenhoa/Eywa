package me.hnguyen.eywa.config.dto;

import me.hnguyen.eywa.config.bean.SenderBean;
import me.hnguyen.eywa.config.entity.SenderEntity;

/**
 * @param <E> ExchangeDto
 * @author hnguyen
 */
public interface SenderDto<E extends ExchangeDto>
    extends SenderBean<E>, ConfigDto<SenderEntity> {

}
