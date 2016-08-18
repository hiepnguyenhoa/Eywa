package me.hnguyen.eywa.logging.dto;

import java.util.Date;
import me.hnguyen.eywa.logging.bean.LoggingBeanImpl;
import me.hnguyen.eywa.logging.entity.LoggingEntity;
import me.hnguyen.eywa.logging.entity.LoggingEntityImpl;

/**
 *
 * @author hnguyen
 */
public class LoggingDtoImpl extends LoggingBeanImpl implements LoggingDto<LoggingEntity> {
    
    public LoggingDtoImpl(){
        
    }
    
    public LoggingDtoImpl(Long id, Date date, String method, String message, String level) {
        super(id, date, method, message, level);
    }

    public LoggingDtoImpl(Date date, String method, String message, String level) {
        super(date, method, message, level);
    }

    @Override
    public LoggingEntity toEntity() {
        return new LoggingEntityImpl(this.id, this.getDate(), this.getMethod(), this.getMessage(), this.getLevel());
    }
    
    @Override
    public String toString(){
        return "date: " + this.getDate() + " method " + this.getMethod();
    }
    
}
