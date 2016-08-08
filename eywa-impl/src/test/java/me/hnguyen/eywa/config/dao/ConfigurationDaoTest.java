package me.hnguyen.eywa.config.dao;

import javax.inject.Inject;
import me.hnguyen.eywa.DaoContext;
import me.hnguyen.eywa.config.bean.ExchangeBean;
import me.hnguyen.eywa.config.bean.ExchangeBeanImpl;
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
import org.junit.Test;

/**
 *
 * @author hnguyen
 */
public class ConfigurationDaoTest extends DaoContext {
    
    private static final String KEY = "localhost";
    
    private static final String AMQ_HOST = "localhost";
    private static final String AMQ_USERNAME = "guest";
    private static final String AMQ_PASSWORD = "guest";
    
    private static final String EXCHANGE_NAME = "localhost_fanout";
    private static final String EXCHANGE_TYPE = "fanout";
    
    private static final String QUEUE_NAME = "queue.fanout";
    
    @Inject
    private ConfigurationDao configDao;
    
//    @Test
//    public void addExchangeTest(){
//        HostEntity hostEntity = new HostEntityImpl();
//        hostEntity.setKey(KEY);
//        hostEntity.setName(AMQ_HOST);
//        hostEntity.setUsername(AMQ_USERNAME);
//        hostEntity.setPassword(AMQ_PASSWORD);
//        configDao.save(hostEntity);
//        
//        ExchangeEntity exchangeEntity = new ExchangeEntityImpl();
//        exchangeEntity.setKey(KEY);
//        exchangeEntity.setName(EXCHANGE_NAME);
//        exchangeEntity.setType(EXCHANGE_TYPE);
//        
//        QueueEntity queueEntity = new QueueEntityImpl();
//        queueEntity.setKey(KEY);
//        queueEntity.setName(QUEUE_NAME);
//        
//        BindingEntity bindingEntity = new BindingEntityImpl();
//        bindingEntity.setKey(KEY);
//        bindingEntity.setExchange(exchangeEntity);
//        bindingEntity.setQueue(queueEntity);
//        configDao.save(bindingEntity);
//        
//        SenderChannelEntity senderChannelEntity = new SenderChannelEntityImpl();
//        senderChannelEntity.setExchange(exchangeEntity);
//        senderChannelEntity.setKey(KEY);
//        configDao.save(senderChannelEntity);
//    }
}
