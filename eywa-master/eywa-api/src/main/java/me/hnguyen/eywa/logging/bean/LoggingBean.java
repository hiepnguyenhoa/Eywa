package me.hnguyen.eywa.logging.bean;

import java.util.Date;

import me.hnguyen.eywa.BaseBean;

/**
 * @author hnguyen
 */
public interface LoggingBean extends BaseBean {

    Date getDate();

    String getMethod();

    String getMessage();

    String getLevel();
}
