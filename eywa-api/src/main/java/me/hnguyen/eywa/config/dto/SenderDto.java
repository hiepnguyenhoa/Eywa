package me.hnguyen.eywa.config.dto;

import me.hnguyen.eywa.config.entity.SenderEntity;
import me.hnguyen.eywa.config.bean.SenderBean;

/**
 *
 * @author hnguyen
 * @param <H> HostDto
 * @param <E> ExchangeDto
 */
public interface SenderDto<H extends HostDto, E extends ExchangeDto>
        extends SenderBean<H, E>, ConfigDto<SenderEntity> {

}
