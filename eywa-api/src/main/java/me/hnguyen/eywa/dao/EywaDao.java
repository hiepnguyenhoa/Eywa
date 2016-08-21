package me.hnguyen.eywa.dao;

import me.hnguyen.eywa.BaseEntity;
import org.springframework.data.neo4j.repository.GraphRepository;

/**
 * @param <T>
 * @author hnguyen
 */
public interface EywaDao<T extends BaseEntity> extends GraphRepository<T> {

}
