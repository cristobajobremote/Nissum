package cl.nissum.register.common.exception;

public class EmailUserException extends RuntimeException{

    public EmailUserException() {
    }

    public EmailUserException(String message) {
        super(message);
    }

    public EmailUserException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmailUserException(Throwable cause) {
        super(cause);
    }

    public EmailUserException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
