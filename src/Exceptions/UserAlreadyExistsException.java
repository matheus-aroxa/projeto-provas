package Exceptions;

public class UserAlreadyExistsException extends RuntimeException {
	
	public UserAlreadyExistsException(String mensagem) {
		super(mensagem);
	}
	
	public UserAlreadyExistsException() {
		super("Usuário já existe");
	}
}
