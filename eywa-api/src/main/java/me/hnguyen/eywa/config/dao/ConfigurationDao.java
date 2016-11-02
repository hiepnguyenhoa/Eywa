package me.hnguyen.eywa.config.dao;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.stereotype.Component;

import java.util.List;

import me.hnguyen.eywa.config.entity.BindingEntity;
import me.hnguyen.eywa.config.entity.ConfigEntity;
import me.hnguyen.eywa.config.entity.ExchangeEntity;
import me.hnguyen.eywa.config.entity.HostEntity;
import me.hnguyen.eywa.config.entity.QueueEntity;
import me.hnguyen.eywa.config.entity.ReceiverEntity;
import me.hnguyen.eywa.config.entity.SenderEntity;
import me.hnguyen.eywa.dao.EywaDao;

/**
 * @author hnguyen
 */
@Component
public interface ConfigurationDao<T extends ConfigEntity> extends EywaDao<T> {

    @Query("MATCH (n:Host) return n")
    <T extends HostEntity> List<T> findHostConfigs();

    @Query("MATCH p=(:Sender)-[]->() RETURN p")
    <T extends SenderEntity> List<T> findSenders(String key);

    @Query("MATCH (n:Exchange) RETURN n")
    <T extends ExchangeEntity> List<T> findExchanges(String key);

    @Query("MATCH (n:Queue) RETURN n")
    <T extends QueueEntity> List<T> findQueues(String key);

    @Query("MATCH p=(:Binding)-[]->() RETURN p")
    <T extends BindingEntity> List<T> findBindings(String key);

    @Query("MATCH p=(:Receiver)-[]->() RETURN p")
    List<ReceiverEntity> findReceivers(String key);

    @Query("MATCH (n) RETURN n")
    List<ConfigEntity> findAllConfig();

}
