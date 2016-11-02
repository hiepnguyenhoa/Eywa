package me.hnguyen.eywa.config.service;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import me.hnguyen.eywa.config.dao.ConfigurationDao;
import me.hnguyen.eywa.config.entity.BindingEntity;
import me.hnguyen.eywa.config.entity.ExchangeEntity;
import me.hnguyen.eywa.config.entity.HostEntity;
import me.hnguyen.eywa.config.entity.QueueEntity;
import me.hnguyen.eywa.config.entity.ReceiverEntity;
import me.hnguyen.eywa.config.entity.SenderEntity;

/**
 * @author hnguyen
 */
@Component
public class InitAQMDataService {

    @Inject
    private ConfigurationDao configDao;
    @Inject
    private HostEntity hostEntity;
    @Inject
    private ExchangeEntity exchangeEntity;
    @Inject
    private QueueEntity queueEntity;
    @Inject
    private BindingEntity bindingEntity;
    @Inject
    private SenderEntity senderEntity;
    @Inject
    private ReceiverEntity receiverEntity;

    @Transactional
    public void initData() {
        configDao.save(hostEntity);

        senderEntity.setExchange(exchangeEntity);
        configDao.save(senderEntity);

        List<BindingEntity> bindingEntities = new ArrayList<>();
        bindingEntity.setExchange(exchangeEntity);
        bindingEntity.setQueue(queueEntity);
        bindingEntities.add(bindingEntity);
        configDao.save(bindingEntities);

        configDao.save(receiverEntity);
    }
}
