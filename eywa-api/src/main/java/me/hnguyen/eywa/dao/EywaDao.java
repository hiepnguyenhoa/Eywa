package me.hnguyen.eywa.dao;

import org.springframework.data.neo4j.repository.GraphRepository;

import me.hnguyen.eywa.BaseEntity;

/**
 * @author hnguyen
 */
public interface EywaDao<T extends BaseEntity> extends GraphRepository<T> {

}
