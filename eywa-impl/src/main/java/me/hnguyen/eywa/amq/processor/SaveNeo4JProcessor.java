package me.hnguyen.eywa.amq.processor;

import org.springframework.stereotype.Component;

import javax.inject.Inject;

import me.hnguyen.eywa.logging.dto.LoggingDto;
import me.hnguyen.eywa.logging.service.LoggingServiceImpl;

/**
 * @author hnguyen
 */
@Component
public class SaveNeo4JProcessor extends MessageProcessorAbst<LoggingDto> {

    @Inject
    private LoggingServiceImpl loggingService;

    @Override
    public void messageProcessing(LoggingDto message) {
        System.out.println("[x] SaveNeo4JProcessor saved " + message.toString());
        loggingService.saveLogging(message);
    }

}
