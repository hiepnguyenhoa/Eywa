package me.hnguyen.eywa.logging.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

import me.hnguyen.eywa.logging.dao.LoggingDao;
import me.hnguyen.eywa.logging.dto.LoggingDto;
import me.hnguyen.eywa.logging.entity.LoggingEntity;

/**
 * Created by hnguyen on 9/14/16.
 */
@Service
public class LoggingServiceImpl implements  LoggingService<LoggingDto>{

    @Inject
    private LoggingDao loggingDao;

    public List<LoggingDto> getAllLogs(int pageNumber, int pageSize) {
        List<LoggingEntity> loggingEntities = (List<LoggingEntity>) loggingDao.findAll();
        final List<LoggingDto> loggingDtos = new ArrayList<>();
        loggingEntities.stream().forEach(entity->loggingDtos.add((LoggingDto) entity.toDto()));
        return loggingDtos;
    }

    public List<LoggingDto> getAllLogs(LoggingDto template, int pageNumber, int pageSize) {
        throw new UnsupportedOperationException();
    }

    public LoggingDto saveLogging(LoggingDto logDto) {
        LoggingEntity loggingEntity = (LoggingEntity) logDto.toEntity();
        loggingEntity = (LoggingEntity) loggingDao.save(loggingEntity);
        return (LoggingDto) loggingEntity.toDto();
    }
}
