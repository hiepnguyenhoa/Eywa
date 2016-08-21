package me.hnguyen.eywa.amq.excpetion;

/**
 * @author hnguyen
 */
public class AMQException extends Exception {

    public AMQException() {
    }

    public AMQException(String message) {
        super(message);
    }

    public AMQException(String message, Throwable cause) {
        super(message, cause);
    }

    public AMQException(Throwable cause) {
        super(cause);
    }

    public AMQException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
