package Exceptions;

public class UserNotExistsException extends RuntimeException {
    public UserNotExistsException(String message) {
        super(message);
    }

    public UserNotExistsException() {
        super("Usuário não existe");
    }
}
