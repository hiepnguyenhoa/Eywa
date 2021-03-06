package me.hnguyen.eywa.config.entity;

import me.hnguyen.eywa.config.bean.QueueBeanImpl;
import me.hnguyen.eywa.config.dto.QueueDto;
import me.hnguyen.eywa.config.dto.QueueDtoImpl;
import org.neo4j.ogm.annotation.NodeEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 *
 * @author hnguyen
 */
@Component
@NodeEntity(label = "Queue")
public class QueueEntityImpl extends QueueBeanImpl implements QueueEntity {

    @Override
    public QueueDto toDto() {
        QueueDto queueDto = new QueueDtoImpl();
        BeanUtils.copyProperties(this, queueDto);
        return queueDto;
    }

}
