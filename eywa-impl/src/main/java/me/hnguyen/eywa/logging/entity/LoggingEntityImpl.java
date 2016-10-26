package me.hnguyen.eywa.logging.entity;

import java.util.Date;
import me.hnguyen.eywa.logging.bean.LoggingBeanImpl;
import me.hnguyen.eywa.logging.dto.LoggingDto;
import me.hnguyen.eywa.logging.dto.LoggingDtoImpl;
import org.neo4j.ogm.annotation.NodeEntity;

/**
 *
 * @author hnguyen
 */
@NodeEntity
public class LoggingEntityImpl extends LoggingBeanImpl implements LoggingEntity<LoggingDto> {

    public LoggingEntityImpl(Date date, String method, String message, String level) {
        super(date, method, message, level);
    }

    public LoggingEntityImpl(Long id, Date date, String method, String message, String level) {
        super(id, date, method, message, level);
    }

    @Override
    public LoggingDto toDto() {
        return new LoggingDtoImpl(this.id, this.getDate(), this.getMethod(), this.getMessage(), this.getLevel());
    }

}
