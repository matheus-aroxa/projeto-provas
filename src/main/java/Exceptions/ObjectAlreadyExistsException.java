package Exceptions;

public class ObjectAlreadyExistsException extends RuntimeException {
	
	public ObjectAlreadyExistsException(String mensagem) {
		super(mensagem);
	}
	
	public ObjectAlreadyExistsException() {
		super("Objeto já existente");
	}
}
