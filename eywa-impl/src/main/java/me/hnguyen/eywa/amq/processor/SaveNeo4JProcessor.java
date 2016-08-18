package me.hnguyen.eywa.amq.processor;

import javax.inject.Inject;
import me.hnguyen.eywa.logging.dto.LoggingDto;
import me.hnguyen.eywa.logging.service.LoggingService;
import org.springframework.stereotype.Component;

/**
 *
 * @author hnguyen
 */
@Component
public class SaveNeo4JProcessor  extends MessageProcessorAbst<LoggingDto> {

    @Inject
    private LoggingService loggingService;
    
    @Override
    public void messageProcessing(LoggingDto message) {
        System.out.println("[x] SaveNeo4JProcessor saved " + message.toString());
        loggingService.saveLogging(message);
    }

}
