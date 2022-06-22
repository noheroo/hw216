package Exceptions;

public class ThisCellIsNotEmptyException extends RuntimeException{
    public ThisCellIsNotEmptyException() {
    }

    public ThisCellIsNotEmptyException(String message) {
        super(message);
    }

    public ThisCellIsNotEmptyException(String message, Throwable cause) {
        super(message, cause);
    }

    public ThisCellIsNotEmptyException(Throwable cause) {
        super(cause);
    }

    public ThisCellIsNotEmptyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
