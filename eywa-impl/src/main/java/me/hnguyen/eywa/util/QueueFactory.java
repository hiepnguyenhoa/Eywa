package me.hnguyen.eywa.util;

import me.hnguyen.eywa.config.bean.QueueBean;
import org.springframework.amqp.core.Queue;

/**
 *
 * @author hnguyen
 */
public class QueueFactory {
    public static Queue createQueue(QueueBean queueDto){
        Queue queue = new Queue(queueDto.getName(),queueDto.isDurable(),queueDto.isExclusive(),queueDto.isAutoDelete());
        return queue;
    }
}
