package me.hnguyen.eywa.config.service;

import java.util.List;
import javax.inject.Inject;
import me.hnguyen.eywa.config.dao.ConfigurationDao;
import me.hnguyen.eywa.config.dto.BindingDto;
import me.hnguyen.eywa.config.dto.ExchangeDto;
import me.hnguyen.eywa.config.dto.HostDto;
import me.hnguyen.eywa.config.dto.QueueDto;
import me.hnguyen.eywa.config.dto.SenderChannelDto;
import me.hnguyen.eywa.util.EywaBeanUtils;
import org.springframework.stereotype.Component;

/**
 *
 * @author hnguyen
 */
@Component
//@Transactional
public class ConfigurationServiceImpl implements ConfigurationService {

    @Inject
    private ConfigurationDao configDAO;

    @Override
    public List<HostDto> getHostConfig() {
        return EywaBeanUtils.toDto(configDAO.findHostConfigs());
    }

    @Override
    public List<SenderChannelDto> getSenderChannels() {
        return EywaBeanUtils.toDto(configDAO.findSenderChannels());
    }

    @Override
    public List<BindingDto> getBindings() {
        return EywaBeanUtils.toDto(configDAO.findBindings());
    }

    @Override
    public List<QueueDto> getQueueDtos() {
        return EywaBeanUtils.toDto(configDAO.findQueues());
    }

    @Override
    public List<ExchangeDto> getExchanges() {
        return EywaBeanUtils.toDto(configDAO.findExchanges());
    }

}
