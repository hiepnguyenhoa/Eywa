package me.hnguyen.eywa.config.entity;

import me.hnguyen.eywa.config.bean.SenderBean;
import me.hnguyen.eywa.config.dto.SenderDto;

/**
 *
 * @author hnguyen
 * @param <H> HostEntity
 * @param <E> ExchangeEntity
 */
public interface SenderEntity<H extends HostEntity, E extends ExchangeEntity>
        extends SenderBean<H, E>, ConfigEntity<SenderDto> {

}
