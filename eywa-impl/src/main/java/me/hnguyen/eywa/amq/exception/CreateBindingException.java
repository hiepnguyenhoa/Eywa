package me.hnguyen.eywa.amq.exception;

/**
 *
 * @author hnguyen
 */
public class CreateBindingException extends RuntimeException {

    public CreateBindingException() {
    }

    public CreateBindingException(String message) {
        super(message);
    }

    public CreateBindingException(String message, Throwable cause) {
        super(message, cause);
    }

    public CreateBindingException(Throwable cause) {
        super(cause);
    }

    public CreateBindingException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
