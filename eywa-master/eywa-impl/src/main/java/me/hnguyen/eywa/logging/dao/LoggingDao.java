package me.hnguyen.eywa.logging.dao;

import me.hnguyen.eywa.dao.EywaDao;
import me.hnguyen.eywa.logging.entity.LoggingEntityImpl;

/**
 * @param <T> LoggingEntity
 * @author hnguyen
 */
public interface LoggingDao<T extends LoggingEntityImpl> extends EywaDao<T> {

}
