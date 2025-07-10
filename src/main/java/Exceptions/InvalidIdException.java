package Exceptions;

public class InvalidIdException extends RuntimeException {
    public InvalidIdException(String message) {
        super(message);
    }

    public InvalidIdException() {
        super("Id deve ser maior que zero");
    }
}
