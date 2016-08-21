package me.hnguyen.eywa.config.service;

import me.hnguyen.eywa.config.dto.*;

import java.util.List;

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
