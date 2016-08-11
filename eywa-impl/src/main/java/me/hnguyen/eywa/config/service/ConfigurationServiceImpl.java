package me.hnguyen.eywa.config.service;

import java.util.List;
import javax.inject.Inject;
import me.hnguyen.eywa.config.dao.ConfigurationDao;
import me.hnguyen.eywa.config.dto.BindingDto;
import me.hnguyen.eywa.config.dto.ExchangeDto;
import me.hnguyen.eywa.config.dto.HostDto;
import me.hnguyen.eywa.config.dto.QueueDto;
import me.hnguyen.eywa.config.dto.ReceiverDto;
import me.hnguyen.eywa.util.EywaBeanUtils;
import org.springframework.stereotype.Component;
import me.hnguyen.eywa.config.dto.SenderDto;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author hnguyen
 */
@Component
@Transactional
public class ConfigurationServiceImpl implements ConfigurationService {

    @Inject
    private ConfigurationDao configDAO;

    @Override
    public List<HostDto> getHostConfig() {
        return EywaBeanUtils.toDto(configDAO.findHostConfigs());
    }

    @Override
    public List<SenderDto> getSenders() {
        return EywaBeanUtils.toDto(configDAO.findSenders());
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

    @Override
    public <T extends ReceiverDto> List<T> getReceivers() {
        return EywaBeanUtils.toDto(configDAO.findReceivers());
    }

}
