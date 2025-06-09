package repos;

import models.usuarios.Aluno;

public class RepositorioAlunos{

    private Aluno[] alunos;
    private static RepositorioAlunos instance;

    private RepositorioAlunos(int tamanho) {
        this.alunos = new Aluno[tamanho];
    }

    public static RepositorioAlunos criar(int tam){
        if(instance == null){
            instance = new RepositorioAlunos(tam);
        }
        return instance;
    }
}
