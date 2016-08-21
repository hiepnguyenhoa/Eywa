package me.hnguyen.eywa.logging.service;

import javax.inject.Inject;
import me.hnguyen.eywa.logging.dao.LoggingDao;
import me.hnguyen.eywa.logging.dto.LoggingDto;
import me.hnguyen.eywa.logging.entity.LoggingEntity;
import org.springframework.stereotype.Component;

/**
 *
 * @author hnguyen
 * @param <T>
 */
@Component
public class LoggingService<T extends LoggingDto> {
    
    @Inject
    private LoggingDao<LoggingEntity> loggingDao;
    
    public void saveLogging(T t){
        LoggingEntity loggingEntity = (LoggingEntity) t.toEntity();
        loggingDao.save(loggingEntity);
    }
}
