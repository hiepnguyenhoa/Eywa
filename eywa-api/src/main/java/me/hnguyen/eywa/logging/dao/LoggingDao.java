package me.hnguyen.eywa.logging.dao;

import me.hnguyen.eywa.dao.EywaDao;
import me.hnguyen.eywa.logging.entity.LoggingEntity;

/**
 * @param <T> LoggingEntity
 * @author hnguyen
 */
public interface LoggingDao<T extends LoggingEntity> extends EywaDao<T> {

}
