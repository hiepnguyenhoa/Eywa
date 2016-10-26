package me.hnguyen.eywa.logging.dao;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import me.hnguyen.eywa.Neo4JContext;
import me.hnguyen.eywa.logging.entity.LoggingEntityImpl;

/**
 * Created by hnguyen on 9/15/16.
 */
@ContextConfiguration(classes = {Neo4JContext.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class LoggingDaoTest {

    @Inject
    private LoggingDao loggingDao;

    @Test
    public void testFindAll(){
        List<LoggingEntityImpl> loggingEntityList = (List<LoggingEntityImpl>)loggingDao.findAll();
        Assert.assertNotEquals(0,loggingEntityList.size());
    }

    @Test
    public void testPersistLoggingEntity(){
        LoggingEntityImpl loggingEntity = new LoggingEntityImpl(new Date(), "Mehod", "the object is created from unit test","INFO");
        loggingDao.save(loggingEntity);
        org.junit.Assert.assertNotEquals(0, loggingEntity.getId().longValue());
    }


}
