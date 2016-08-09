package me.hnguyen.eywa.config.dao;

import java.util.List;
import me.hnguyen.eywa.config.entity.BindingEntity;
import me.hnguyen.eywa.config.entity.ConfigEntity;
import me.hnguyen.eywa.config.entity.ExchangeEntity;
import me.hnguyen.eywa.config.entity.HostEntity;
import me.hnguyen.eywa.config.entity.QueueEntity;
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

    @Query("MATCH (n:SenderChannel) RETURN n")
    public <T extends SenderChannelEntity> List<T> findSenderChannels();
    
     @Query("MATCH (SenderChannel)-[EXCHANGE]->(m:Exchange) RETURN m")
    public <T extends ExchangeEntity> List<T> findExchanges();
    
    @Query("MATCH (n:Queue) RETURN n")
    public <T extends QueueEntity> List<T> findQueues();
    
    @Query("MATCH (n:Binding)-[r:QUEUE]->(m:Queue) RETURN n,r,m")
    public <T extends BindingEntity> List<T> findBindings();
    
}
