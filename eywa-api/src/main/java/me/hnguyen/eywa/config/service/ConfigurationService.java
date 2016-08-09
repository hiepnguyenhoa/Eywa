package me.hnguyen.eywa.config.service;

import java.util.List;
import me.hnguyen.eywa.config.dto.BindingDto;
import me.hnguyen.eywa.config.dto.ExchangeDto;
import me.hnguyen.eywa.config.dto.HostDto;
import me.hnguyen.eywa.config.dto.QueueDto;
import me.hnguyen.eywa.config.dto.SenderChannelDto;

/**
 *
 * @author hnguyen
 */
public interface ConfigurationService {
    
    public <T extends HostDto> List<T> getHostConfig();

    public <T extends SenderChannelDto> List<T> getSenderChannels();

    public <T extends BindingDto> List<T> getBindings();

    public <T extends QueueDto> List<T> getQueueDtos();

    public <T extends ExchangeDto> List<T> getExchanges();
    
}
