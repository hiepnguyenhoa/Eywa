package me.hnguyen.eywa.config.service;

import java.util.List;

import me.hnguyen.eywa.config.dto.BindingDto;
import me.hnguyen.eywa.config.dto.ExchangeDto;
import me.hnguyen.eywa.config.dto.HostDto;
import me.hnguyen.eywa.config.dto.QueueDto;
import me.hnguyen.eywa.config.dto.ReceiverDto;
import me.hnguyen.eywa.config.dto.SenderDto;

/**
 * @author hnguyen
 */
public interface ConfigurationService {

    <T extends HostDto> List<T> getHostConfig();

    <T extends SenderDto> List<T> getSenders(String key);

    <T extends BindingDto> List<T> getBindings(String key);

    <T extends QueueDto> List<T> getQueueDtos(String key);

    <T extends ExchangeDto> List<T> getExchanges(String key);

    <T extends ReceiverDto> List<T> getReceivers(String key);

}
