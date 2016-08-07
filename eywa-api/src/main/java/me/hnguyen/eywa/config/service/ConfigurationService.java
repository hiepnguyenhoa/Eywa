package me.hnguyen.eywa.config.service;

import me.hnguyen.eywa.config.dto.HostDto;
import me.hnguyen.eywa.config.dto.SenderChannelDto;

/**
 *
 * @author hnguyen
 */
public interface ConfigurationService {
    
    public <T extends HostDto> T getHostConfig();

    public <T extends SenderChannelDto> T getProducerChannel();
    
}
