package me.hnguyen.eywa.config.entity;

import me.hnguyen.eywa.config.bean.SenderChannelBean;
import me.hnguyen.eywa.config.dto.SenderChannelDto;

/**
 *
 * @author hnguyen
 * @param <E>
 */
public interface SenderChannelEntity<E extends ExchangeEntity>
        extends SenderChannelBean<E>, ConfigEntity<SenderChannelDto> {

}
