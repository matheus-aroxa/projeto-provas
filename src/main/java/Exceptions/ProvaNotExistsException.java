package Exceptions;

public class ProvaNotExistsException extends RuntimeException {
    
    public ProvaNotExistsException(String mensagem){
        super(mensagem);
    }
    
    public ProvaNotExistsException(){
        super("Prova não existe");
    }

}
