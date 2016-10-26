package me.hnguyen.eywa.amq.processor;

import me.hnguyen.eywa.logging.dto.LoggingDto;

/**
 * @author hnguyen
 */
public class PrintOutMessageProcessor extends MessageProcessorAbst<LoggingDto> {

    @Override
    public void messageProcessing(LoggingDto message) {
        System.out.println("[x] PrintOutMessageProcessor receives " + message.toString());
    }

}
