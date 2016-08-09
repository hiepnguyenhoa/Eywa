package me.hnguyen.eywa.config.dao;

import javax.inject.Inject;
import me.hnguyen.eywa.DaoContext;
import me.hnguyen.eywa.config.entity.BindingEntity;
import me.hnguyen.eywa.config.entity.BindingEntityImpl;
import me.hnguyen.eywa.config.entity.ExchangeEntity;
import me.hnguyen.eywa.config.entity.ExchangeEntityImpl;
import me.hnguyen.eywa.config.entity.HostEntity;
import me.hnguyen.eywa.config.entity.HostEntityImpl;
import me.hnguyen.eywa.config.entity.QueueEntity;
import me.hnguyen.eywa.config.entity.QueueEntityImpl;
import me.hnguyen.eywa.config.entity.SenderChannelEntity;
import me.hnguyen.eywa.config.entity.SenderChannelEntityImpl;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author hnguyen
 */
@Ignore
public class ConfigurationDaoTest extends DaoContext {
    
    private static final String KEY = "localhost";
    private static final String ROUTING_KEY = "localhost.all";
    private static final String AMQ_HOST = "localhost";
    private static final String AMQ_USERNAME = "guest";
    private static final String AMQ_PASSWORD = "guest";
    
    private static final String EXCHANGE_NAME_1 = "localhost.fanout";
    private static final String EXCHANGE_TYPE_1 = "fanout";
    private static final String EXCHANGE_NAME_2 = "localhost.direct";
    private static final String EXCHANGE_TYPE_2 = "direct";
    
    private static final String QUEUE_NAME_1 = "queue.1";
    private static final String QUEUE_NAME_2 = "queue.2";
    private static final String QUEUE_NAME_3 = "queue.3";
    
    @Inject
    private ConfigurationDao configDao;
    
    @Test
    public void addExchangeTest(){
        HostEntity hostEntity = new HostEntityImpl();
        hostEntity.setKey(KEY);
        hostEntity.setName(AMQ_HOST);
        hostEntity.setUsername(AMQ_USERNAME);
        hostEntity.setPassword(AMQ_PASSWORD);
        configDao.save(hostEntity);
        
        ExchangeEntity fanoutExchangeEntity = new ExchangeEntityImpl();
        fanoutExchangeEntity.setKey(KEY);
        fanoutExchangeEntity.setName(EXCHANGE_NAME_1);
        fanoutExchangeEntity.setType(EXCHANGE_TYPE_1);
        
        ExchangeEntity directtExchangeEntity = new ExchangeEntityImpl();
        directtExchangeEntity.setKey(KEY);
        directtExchangeEntity.setName(EXCHANGE_NAME_2);
        directtExchangeEntity.setType(EXCHANGE_TYPE_2);
        
        SenderChannelEntity senderChannelEntity = new SenderChannelEntityImpl();
        senderChannelEntity.setExchange(fanoutExchangeEntity);
        senderChannelEntity.setKey(KEY);
        configDao.save(senderChannelEntity);
        
        senderChannelEntity = new SenderChannelEntityImpl();
        senderChannelEntity.setExchange(directtExchangeEntity);
        senderChannelEntity.setKey(KEY);
        configDao.save(senderChannelEntity);
        
        QueueEntity queueEntity = new QueueEntityImpl();
        queueEntity.setKey(KEY);
        queueEntity.setName(QUEUE_NAME_1);
        BindingEntity bindingEntity = new BindingEntityImpl();
        bindingEntity.setKey(KEY);
        bindingEntity.setExchange(fanoutExchangeEntity);
        bindingEntity.setQueue(queueEntity);
        configDao.save(bindingEntity);
        
        queueEntity = new QueueEntityImpl();
        queueEntity.setKey(KEY);
        queueEntity.setName(QUEUE_NAME_2);
        
        configDao.save(queueEntity);
        
    }
    
    @Test
    public void testFindQueues(){
        Assert.assertNotEquals(0, configDao.findQueues().size());
    }
  
}
