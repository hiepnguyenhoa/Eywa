package me.hnguyen.eywa.amq;

import me.hnguyen.eywa.amq.excpetion.AMQException;

/**
 *
 * @author hnguyen
 */
public interface AMQConnection {
    
    public boolean isIdle();
    
    public AMQChannel getChannel() throws AMQException;
    
}
