package Exceptions;

// Exceção para encapsular erros do serviço de e-mail
public class EmailException extends RuntimeException {
    public EmailException(String message, Throwable cause) {
        super(message, cause);
    }
}