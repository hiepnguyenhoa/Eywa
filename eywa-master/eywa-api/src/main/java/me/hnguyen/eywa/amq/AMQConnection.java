package me.hnguyen.eywa.amq;

import me.hnguyen.eywa.amq.excpetion.AMQException;

/**
 * @author hnguyen
 */
public interface AMQConnection {

    boolean isIdle();

    AMQChannel getChannel() throws AMQException;

}
