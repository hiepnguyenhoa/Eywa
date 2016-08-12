package me.hnguyen.eywa.amq.rabbitmq;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import me.hnguyen.eywa.amq.service.EywaSenderImpl;
import me.hnguyen.eywa.config.bean.SenderBean;
import me.hnguyen.eywa.config.dto.HostDto;
import me.hnguyen.eywa.config.dto.SenderDto;
import me.hnguyen.eywa.config.service.ConfigurationService;
import me.hnguyen.eywa.amq.service.EywaSender;
import me.hnguyen.eywa.util.EywaBeanUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author hnguyen
 */
@Configuration
public class EywaSenderConfigImpl extends EywaAMQServerConfigImpl implements EywaSenderConfig {

    @Inject
    private ConfigurationService configService;
    
    private final EywaSenderFacory eywaSenderFactory = new EywaSenderFacory();
    
    private final Map<String, EywaSender> eywaSenders = new HashMap<>();

    @PostConstruct
    public void inititializeSenders() {
        List<HostDto> hostDtos = configService.getHostConfig();
        hostDtos.stream().forEach((hostDto) -> {
            initializeSender(EywaBeanUtils.buildConfigBeanKey(hostDto));
        });
    }
    
    public EywaSender getEywaSender(String key){
        return eywaSenders.get(key);
    }
    
    public List<EywaSender> getEywaSenders(){
        return new ArrayList(eywaSenders.values());
    }

    private void initializeSender(String key) {
        List<SenderDto> senderDtos = configService.getSenders(key);
        senderDtos.stream().forEach((senderDto) -> 
                eywaSenders.put(EywaBeanUtils.buildConfigBeanKey(senderDto), eywaSenderFactory.createEywaSender(senderDto)));
    }
    
    class EywaSenderFacory{
        EywaSender createEywaSender(SenderBean senderDto){
            EywaSender eywaSender = new EywaSenderImpl(
                    getConnectionFactory(EywaBeanUtils.buildConfigBeanKey(senderDto.getHost()))
                    , senderDto.getName(), senderDto.getRouting());
            return eywaSender;
        }
    }

}
