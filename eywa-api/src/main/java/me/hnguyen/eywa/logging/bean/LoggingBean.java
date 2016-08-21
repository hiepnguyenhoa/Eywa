package me.hnguyen.eywa.logging.bean;

import java.util.Date;

/**
 * @author hnguyen
 */
public interface LoggingBean {

    Date getDate();

    String getMethod();

    String getMessage();

    String getLevel();
}
