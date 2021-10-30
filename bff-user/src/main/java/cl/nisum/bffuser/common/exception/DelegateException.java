package cl.nisum.bffuser.common.exception;

public class DelegateException extends RuntimeException{

    public DelegateException() {
    }

    public DelegateException(String message) {
        super(message);
    }

    public DelegateException(String message, Throwable cause) {
        super(message, cause);
    }

    public DelegateException(Throwable cause) {
        super(cause);
    }

    public DelegateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
