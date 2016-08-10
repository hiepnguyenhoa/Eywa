package me.hnguyen.eywa.amq.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 *
 * @author hnguyen
 */
@Service
public class FanoutReceiver {

//    @RabbitListener(queues = "localhost")
    public void processMessage(String msg) {
        System.out.println(msg);
    }
    
}
