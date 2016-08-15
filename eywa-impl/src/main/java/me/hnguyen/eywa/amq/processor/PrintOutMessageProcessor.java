package me.hnguyen.eywa.amq.processor;

import org.springframework.stereotype.Component;
import me.hnguyen.eywa.amq.service.MessageProcessorAbst;

/**
 *
 * @author hnguyen
 */
public class PrintOutMessageProcessor extends MessageProcessorAbst<String> {

    @Override
    public void messageProcessing(String message) {
        System.out.println("[x] Receive message " + message);
    }
    
}
