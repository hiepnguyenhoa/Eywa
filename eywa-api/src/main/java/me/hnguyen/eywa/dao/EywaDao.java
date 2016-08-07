package me.hnguyen.eywa.dao;

import me.hnguyen.eywa.BaseEntity;
import org.springframework.data.neo4j.repository.GraphRepository;

/**
 *
 * @author hnguyen
 * @param <T>
 */
public interface EywaDao<T extends BaseEntity> extends GraphRepository<T> {
    
}
