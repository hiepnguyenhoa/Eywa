package me.hnguyen.eywa.config.entity;

import me.hnguyen.eywa.config.bean.HostBeanImpl;
import me.hnguyen.eywa.config.dto.HostDto;
import me.hnguyen.eywa.config.dto.HostDtoImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 *
 * @author hnguyen
 */
@Component
public class HostEntityImpl extends HostBeanImpl implements HostEntity {

    @Override
    public HostDto toDto() {
        HostDto hostDto = new HostDtoImpl();
        BeanUtils.copyProperties(this, hostDto);
        return hostDto;
    }

}
