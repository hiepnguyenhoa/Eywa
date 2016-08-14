package me.hnguyen.eywa.receiver;

import me.hnguyen.eywa.amq.service.EywaReceiver;
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
        System.out.println("[x] "+Thread.currentThread().getName()+" Received message " + message);
    }
    
}
