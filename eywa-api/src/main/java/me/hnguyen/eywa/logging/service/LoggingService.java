package me.hnguyen.eywa.logging.service;

import java.util.List;
import me.hnguyen.eywa.logging.dto.LoggingDto;

/**
 *
 * @author hnguyen
 * @param <T>
 */
public interface LoggingService<T extends LoggingDto> {

    public List<T> getAllLogs(int pageNumber, int pageSize);

    public List<T> getAllLogs(LoggingDto template, int pageNumber, int pageSize);
    
    public T saveLogging(T logDto);
    
}
