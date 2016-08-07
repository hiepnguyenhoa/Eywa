package me.hnguyen.eywa.config.dao;

import me.hnguyen.eywa.config.entity.HostEntity;
import me.hnguyen.eywa.dao.EywaDao;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.stereotype.Repository;
import me.hnguyen.eywa.config.entity.SenderChannelEntity;

/**
 *
 * @author hnguyen
 */
@Repository
public interface ConfigurationDao extends EywaDao {

    @Query("MATCH (n:HostConfig) return n")
    public <T extends HostEntity> T findHostConfig();

    @Query("MATCH (n:ChannelConfig) return n")
    public <T extends SenderChannelEntity> T findProducerChannel();
    
}
