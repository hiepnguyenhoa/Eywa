package me.hnguyen.eywa.config.entity;

import org.neo4j.ogm.annotation.NodeEntity;

import me.hnguyen.eywa.config.bean.HostBeanImpl;
import me.hnguyen.eywa.config.dto.HostDto;
import me.hnguyen.eywa.config.dto.HostDtoImpl;
import me.hnguyen.eywa.util.EywaBeanUtils;

/**
 * @author hnguyen
 */
@NodeEntity(label = "Host")
public class HostEntityImpl extends HostBeanImpl implements HostEntity {

    @Override
    public HostDto toDto() {
        HostDto hostDto = new HostDtoImpl();
        EywaBeanUtils.copyProperties(this, hostDto);
        return hostDto;
    }

}
