package me.hnguyen.eywa.receiver;

import me.hnguyen.eywa.logging.dto.LoggingDtoImpl;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 *
 * @author hnguyen
 */
@Component
public class EywaReceiver {
    
    @RabbitListener(queues = {"simple.queue.name", "eywa.fanout"})
    public void process(LoggingDtoImpl msg){
        System.out.println("========== MESSAGE " + msg.toString());
    }
}
