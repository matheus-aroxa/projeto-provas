package Exceptions;

public class QuestaoNotExistsException extends RuntimeException{
    
    public QuestaoNotExistsException(){
        super("Questão não existe");
    }

    public QuestaoNotExistsException(String mensagem){
        super(mensagem);
    }

}
