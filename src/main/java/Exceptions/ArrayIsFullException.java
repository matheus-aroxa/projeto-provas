package Exceptions;

public class ArrayIsFullException extends RuntimeException {
    public ArrayIsFullException(String message) {
        super(message);
    }

    public ArrayIsFullException() {
        super("O array está cheio");
    }
}
