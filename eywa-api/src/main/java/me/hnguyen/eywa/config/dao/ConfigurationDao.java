package me.hnguyen.eywa.config.dao;

import java.util.List;
import me.hnguyen.eywa.config.entity.BindingEntity;
import me.hnguyen.eywa.config.entity.ConfigEntity;
import me.hnguyen.eywa.config.entity.ExchangeEntity;
import me.hnguyen.eywa.config.entity.HostEntity;
import me.hnguyen.eywa.config.entity.QueueEntity;
import me.hnguyen.eywa.config.entity.ReceiverEntity;
import me.hnguyen.eywa.dao.EywaDao;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.stereotype.Component;
import me.hnguyen.eywa.config.entity.SenderEntity;

/**
 *
 * @author hnguyen
 * @param <T>
 */
@Component
public interface ConfigurationDao<T extends ConfigEntity> extends EywaDao<T> {

    @Query("MATCH (n:Host) return n")
    public <T extends HostEntity> List<T> findHostConfigs();

    @Query("MATCH p=()-[r:EXCHANGE]->() RETURN p")
    public <T extends SenderEntity> List<T> findSenders();

    @Query("MATCH (n:Exchange) RETURN n")
    public <T extends ExchangeEntity> List<T> findExchanges();

    @Query("MATCH (n:Queue)-[]-() RETURN n")
    public <T extends QueueEntity> List<T> findQueues();

    @Query("MATCH (n:Binding) RETURN n")
    public <T extends BindingEntity> List<T> findBindings();
    
    @Query("MATCH p=(:Receiver)-[:BINDINGS]->()-[]-() RETURN p")
    public List<ReceiverEntity> findReceivers();

}
