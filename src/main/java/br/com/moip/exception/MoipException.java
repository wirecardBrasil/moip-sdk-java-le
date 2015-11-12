package br.com.moip.exception;

public class MoipException extends RuntimeException {

    public MoipException() {
    }

    public MoipException(final String message) {
        super(message);
    }

    public MoipException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public MoipException(final Throwable cause) {
        super(cause);
    }

    public MoipException(final String message, final Throwable cause, final boolean enableSuppression, final boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
