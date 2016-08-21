package me.hnguyen.eywa.config.entity;

import me.hnguyen.eywa.config.bean.SenderBean;
import me.hnguyen.eywa.config.dto.SenderDto;

/**
 * @param <E> ExchangeEntity
 * @author hnguyen
 */
public interface SenderEntity<E extends ExchangeEntity>
        extends SenderBean<E>, ConfigEntity<SenderDto> {

}
