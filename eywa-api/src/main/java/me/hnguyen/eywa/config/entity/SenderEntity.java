package me.hnguyen.eywa.config.entity;

import me.hnguyen.eywa.config.bean.SenderBean;
import me.hnguyen.eywa.config.dto.SenderDto;

/**
 *
 * @author hnguyen
 * @param <E> ExchangeEntity
 */
public interface SenderEntity<E extends ExchangeEntity>
        extends SenderBean<E>, ConfigEntity<SenderDto> {

}
