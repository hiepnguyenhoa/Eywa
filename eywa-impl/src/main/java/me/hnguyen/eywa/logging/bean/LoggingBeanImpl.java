package me.hnguyen.eywa.logging.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.ws.rs.FormParam;
import me.hnguyen.eywa.BaseBeanAbst;

/**
 *
 * @author hnguyen
 */
public class LoggingBeanImpl extends BaseBeanAbst implements LoggingBean, Serializable {

    @FormParam("date")
    private  Date date;
    @FormParam("method")
    private  String method;
    @FormParam("message")
    private  String message;
    @FormParam("level")
    private  String level;
    
    public LoggingBeanImpl(){
        super();
    }

    public LoggingBeanImpl(Long id, Date date, String method, String message, String level) {
        this.id = id;
        this.date = date;
        this.method = method;
        this.message = message;
        this.level = level;
    }

    public LoggingBeanImpl(Date date, String method, String message, String level) {
        this.date = date;
        this.method = method;
        this.message = message;
        this.level = level;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.date);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final LoggingBeanImpl other = (LoggingBeanImpl) obj;
        return Objects.equals(this.date, other.date);
    }

    @Override
    public String getMessage() {
        return this.message;
    }

}
