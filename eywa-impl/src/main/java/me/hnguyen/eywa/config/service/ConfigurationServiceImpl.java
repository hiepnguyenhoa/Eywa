package me.hnguyen.eywa.config.service;

import javax.inject.Inject;
import me.hnguyen.eywa.config.dao.ConfigurationDao;
import me.hnguyen.eywa.config.dto.HostDto;
import me.hnguyen.eywa.config.entity.ExchangeEntity;
import me.hnguyen.eywa.config.entity.HostEntity;
import org.springframework.stereotype.Service;
import me.hnguyen.eywa.config.entity.SenderChannelEntity;
import me.hnguyen.eywa.config.dto.SenderChannelDto;

/**
 *
 * @author hnguyen
 */
@Service
public class ConfigurationServiceImpl implements ConfigurationService {

//    @Inject
    private ConfigurationDao configDAO;

    @Inject
    private HostEntity defHost;

    @Inject
    private SenderChannelEntity defChannel;
    
    @Inject
    private ExchangeEntity exchangeEntity;
    

    @Override
    public HostDto getHostConfig() {
        HostEntity hostEntity = null;
//        hostEntity = configDAO.findHostConfig();
        if (hostEntity == null) {
            hostEntity = defHost;
        }
        return hostEntity.toDto();
    }

    //TODO: don't know why it return BaseDto
    @Override
    public SenderChannelDto getProducerChannel() {
        SenderChannelEntity producerChannelEntity = null;
//        producerChannelEntity = configDAO.findProducerChannel();
        if (producerChannelEntity == null) {
            defChannel.setExchange(exchangeEntity);
            producerChannelEntity = defChannel;
        }
        return (SenderChannelDto) producerChannelEntity.toDto();
    }

}
