package me.hnguyen.eywa.config.service;

import java.util.List;
import javax.inject.Inject;
import me.hnguyen.eywa.config.dao.ConfigurationDao;
import me.hnguyen.eywa.config.dto.HostDto;
import me.hnguyen.eywa.config.entity.HostEntity;
import me.hnguyen.eywa.config.entity.SenderChannelEntity;
import me.hnguyen.eywa.config.dto.SenderChannelDto;
import me.hnguyen.eywa.util.EywaBeanUtils;
import org.springframework.stereotype.Component;

/**
 *
 * @author hnguyen
 */
@Component
public class ConfigurationServiceImpl implements ConfigurationService {

    @Inject
    private ConfigurationDao configDAO;

    @Override
    public List<HostDto> getHostConfig() {
        List<HostEntity> hostEntities = configDAO.findHostConfigs();
        return EywaBeanUtils.toDto(hostEntities);
    }

    @Override
    public List<SenderChannelDto> getProducerChannels() {
        List<SenderChannelEntity> senderChannelEntities = configDAO.findProducerChannels();
        List<SenderChannelDto> senderChannelDto =  EywaBeanUtils.toDto(senderChannelEntities);
        return senderChannelDto;
    }

}
