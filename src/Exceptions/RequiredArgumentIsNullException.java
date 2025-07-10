package Exceptions;

public class RequiredArgumentIsNullException extends RuntimeException {
	
	public RequiredArgumentIsNullException(String mensagem) {
		super(mensagem);
	}
	
	public RequiredArgumentIsNullException() {
		super("Argumento necessário não pode ser nulo");
	}
}
