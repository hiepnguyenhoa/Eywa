package me.hnguyen.eywa.util;

import me.hnguyen.eywa.config.bean.QueueBean;
import org.apache.commons.lang3.Validate;
import org.springframework.amqp.core.Queue;

/**
 *
 * @author hnguyen
 */
public class EywaQueueFactory {
    public static Queue createQueue(QueueBean queueDto){
        Validate.notNull(queueDto);
        Queue queue = new Queue(queueDto.getName(),queueDto.isDurable(),queueDto.isExclusive(),queueDto.isAutoDelete());
        return queue;
    }
}
