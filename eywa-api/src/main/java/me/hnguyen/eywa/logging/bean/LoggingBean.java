package me.hnguyen.eywa.logging.bean;

import java.util.Date;

/**
 *
 * @author hnguyen
 */
public interface LoggingBean {

    public Date getDate();

    public String getMethod();
    
    public String getMessage();

    public String getLevel();
}
