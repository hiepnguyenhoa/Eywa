package me.hnguyen.eywa.amq.exception;

/**
 *
 * @author hnguyen
 */
public class CreateExchangeException extends RuntimeException {

    public CreateExchangeException() {
    }

    public CreateExchangeException(String message) {
        super(message);
    }

    public CreateExchangeException(String message, Throwable cause) {
        super(message, cause);
    }

    public CreateExchangeException(Throwable cause) {
        super(cause);
    }

    public CreateExchangeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
