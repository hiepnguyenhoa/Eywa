package me.hnguyen.eywa.config.entity;

import org.neo4j.ogm.annotation.NodeEntity;
import org.springframework.beans.BeanUtils;

import me.hnguyen.eywa.config.bean.QueueBeanImpl;
import me.hnguyen.eywa.config.dto.QueueDto;
import me.hnguyen.eywa.config.dto.QueueDtoImpl;

/**
 * @author hnguyen
 */
@NodeEntity(label = "Queue")
public class QueueEntityImpl extends QueueBeanImpl implements QueueEntity {

    @Override
    public QueueDto toDto() {
        QueueDto queueDto = new QueueDtoImpl();
        BeanUtils.copyProperties(this, queueDto);
        return queueDto;
    }

}
