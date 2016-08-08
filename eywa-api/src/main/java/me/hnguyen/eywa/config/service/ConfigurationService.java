package me.hnguyen.eywa.config.service;

import java.util.List;
import me.hnguyen.eywa.config.dto.HostDto;
import me.hnguyen.eywa.config.dto.SenderChannelDto;

/**
 *
 * @author hnguyen
 */
public interface ConfigurationService {
    
    public <T extends HostDto> List<T> getHostConfig();

    public <T extends SenderChannelDto> List<T> getProducerChannels();
    
}
