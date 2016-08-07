package me.hnguyen.eywa.config.dto;

import me.hnguyen.eywa.config.bean.SenderChannelBean;
import me.hnguyen.eywa.config.entity.SenderChannelEntity;

/**
 *
 * @author hnguyen
 * @param <E>
 */
public interface SenderChannelDto<E extends ExchangeDto>
        extends SenderChannelBean<E>, ConfigDto<SenderChannelEntity> {

}
