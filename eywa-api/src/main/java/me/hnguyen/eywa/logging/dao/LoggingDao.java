package me.hnguyen.eywa.logging.dao;

import me.hnguyen.eywa.dao.EywaDao;
import me.hnguyen.eywa.logging.entity.LoggingEntity;

/**
 *
 * @author hnguyen
 * @param <T> LoggingEntity
 */
public interface LoggingDao<T extends LoggingEntity> extends EywaDao<T> {
    
}
