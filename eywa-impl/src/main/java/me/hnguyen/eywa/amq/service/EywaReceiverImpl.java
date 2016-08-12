package me.hnguyen.eywa.amq.service;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 *
 * @author hnguyen
 */
@Component
public class EywaReceiverImpl implements EywaReceiver<String> {

    @Override
    @RabbitListener(queues = {"localhost"})
    public void process(String message) {
        try {
            System.out.println("[x] "+Thread.currentThread().getName()+" Received message " + message);
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            Logger.getLogger(EywaReceiverImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
