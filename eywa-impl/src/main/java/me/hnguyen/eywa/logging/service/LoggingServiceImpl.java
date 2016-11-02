package me.hnguyen.eywa.logging.service;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import me.hnguyen.eywa.logging.dao.LoggingDao;
import me.hnguyen.eywa.logging.dto.LoggingDto;
import me.hnguyen.eywa.logging.entity.LoggingEntity;
import me.hnguyen.eywa.logging.entity.LoggingEntityImpl;

/**
 * @author hnguyen
 */
@Service("loggingService")
public class LoggingServiceImpl<T extends LoggingDto> implements LoggingService<T> {

    @Inject
    private LoggingDao loggingDao;

    @Override
    public T saveLogging(T t) {
        LoggingEntityImpl loggingEntity = (LoggingEntityImpl) t.toEntity();
        loggingDao.save(loggingEntity);
        List<LoggingEntityImpl> loggingEntities = (List<LoggingEntityImpl>) loggingDao.findAll();
        return null;
    }

    @Override
    public List<T> getAllLogs(int pageNumber, int pageSize) {
        List<T> loggingDtos = new ArrayList<>();
        Pageable paging = createPageable(pageNumber, pageSize);
        List<LoggingEntityImpl> loggingEntities = (List<LoggingEntityImpl>) loggingDao.findAll();
        loggingEntities
            .stream()
            .forEach((loggingEntity) -> loggingDtos.add((T) loggingEntity.toDto()));
        return loggingDtos;
    }

    @Override
    public List<T> getAllLogs(LoggingDto template, int pageNumber, int pageSize) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private Pageable createPageable(int pageNumber, int pageSize) {
        return new PageRequest(pageNumber, pageSize, Sort.Direction.DESC, LoggingEntity.ID);
    }
}
