package me.hnguyen.eywa.config.dto;

import me.hnguyen.eywa.config.entity.SenderEntity;
import me.hnguyen.eywa.config.bean.SenderBean;

/**
 *
 * @author hnguyen
 * @param <E>
 */
public interface SenderDto<E extends ExchangeDto>
        extends SenderBean<E>, ConfigDto<SenderEntity> {

}
