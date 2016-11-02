package me.hnguyen.eywa.sender;

import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import me.hnguyen.eywa.amq.rabbitmq.RabbitConfig;
import me.hnguyen.eywa.amq.service.EywaSender;
import me.hnguyen.eywa.config.bean.SenderBean;
import me.hnguyen.eywa.config.dto.HostDto;
import me.hnguyen.eywa.config.dto.SenderDto;
import me.hnguyen.eywa.config.service.ConfigurationService;

/**
 * @author hnguyen
 */
@Configuration
public class EywaSenderConfigImpl extends RabbitConfig {

    @Inject
    private ConfigurationService configService;

    private final EywaSenderFacory eywaSenderFactory = new EywaSenderFacory();

    private final Map<String, EywaSender> eywaSenders = new HashMap<>();

    @PostConstruct
    public void inititializeSenders() {
        List<HostDto> hostDtos = configService.getHostConfig();
        hostDtos.stream().forEach((hostDto) -> {
            initializeSender(hostDto.getKeyMap());
        });
    }

    public EywaSender getEywaSender(String key) {
        return eywaSenders.get(key);
    }

    public List<EywaSender> getEywaSenders() {
        return new ArrayList(eywaSenders.values());
    }

    private void initializeSender(String key) {
        List<SenderDto> senderDtos = configService.getSenders(key);
        senderDtos.stream().forEach((senderDto) ->
                                        eywaSenders.put(senderDto.getKeyMap(), eywaSenderFactory.createEywaSender(senderDto)));
    }

    class EywaSenderFacory {

        EywaSender createEywaSender(SenderBean senderDto) {
            EywaSender eywaSender = new EywaSenderImpl(
                getConnectionFactory(senderDto.getKey())
                , senderDto.getExchange().getName(), senderDto.getRouting(), getMessageConverter());
            return eywaSender;
        }
    }

}
