package me.hnguyen.eywa.config.service;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import me.hnguyen.eywa.config.dao.ConfigurationDao;
import me.hnguyen.eywa.config.dto.BindingDto;
import me.hnguyen.eywa.config.dto.ExchangeDto;
import me.hnguyen.eywa.config.dto.HostDto;
import me.hnguyen.eywa.config.dto.QueueDto;
import me.hnguyen.eywa.config.dto.ReceiverDto;
import me.hnguyen.eywa.config.dto.SenderDto;
import me.hnguyen.eywa.config.entity.ReceiverEntity;
import me.hnguyen.eywa.util.EywaBeanUtils;

/**
 * @author hnguyen
 */
@Component
@Transactional
public class ConfigurationServiceImpl implements ConfigurationService {

    @Inject
    private ConfigurationDao configDAO;

    @Override
    public <T extends HostDto> List<T> getHostConfig() {
        return EywaBeanUtils.toDto(configDAO.findHostConfigs());
    }

    @Override
    public <T extends SenderDto> List<T> getSenders(String key) {
        return EywaBeanUtils.toDto(configDAO.findSenders(key));
    }

    @Override
    public <T extends BindingDto> List<T> getBindings(String key) {
        return EywaBeanUtils.toDto(configDAO.findBindings(key));
    }

    @Override
    public <T extends QueueDto> List<T> getQueueDtos(String key) {
        return EywaBeanUtils.toDto(configDAO.findQueues(key));
    }

    @Override
    public <T extends ExchangeDto> List<T> getExchanges(String key) {
        return EywaBeanUtils.toDto(configDAO.findExchanges(key));
    }

    @Override
    public <T extends ReceiverDto> List<T> getReceivers(String key) {
        List<ReceiverEntity> receiverEntities = configDAO.findReceivers(key);
        List<T> receiverDtos = new ArrayList<>();
        for (ReceiverEntity receiverEntity : receiverEntities) {
            T receiverDto = (T) receiverEntity.toDto();
            receiverDtos.add(receiverDto);
        }
        return receiverDtos;
    }

}
