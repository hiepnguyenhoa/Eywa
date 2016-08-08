package me.hnguyen.eywa.config.dao;

import java.util.List;
import me.hnguyen.eywa.config.entity.ConfigEntity;
import me.hnguyen.eywa.config.entity.HostEntity;
import me.hnguyen.eywa.dao.EywaDao;
import org.springframework.data.neo4j.annotation.Query;
import me.hnguyen.eywa.config.entity.SenderChannelEntity;
import org.springframework.stereotype.Component;

/**
 *
 * @author hnguyen
 * @param <T>
 */
@Component
public interface ConfigurationDao<T extends ConfigEntity> extends EywaDao<T> {

    @Query("MATCH (n:Host) return n")
    public <T extends HostEntity> List<T> findHostConfigs();

    @Query("MATCH (n:SenderChannel)-[r:EXCHANGE]-(m) RETURN n,m,r")
    public <T extends SenderChannelEntity> List<T> findProducerChannels();
    
}
