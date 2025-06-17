package repos;

import models.usuarios.Aluno;
import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicInteger;

public class RepositorioAlunos{

    private Aluno[] alunos;
    private static AtomicInteger contador = new AtomicInteger();
    private static RepositorioAlunos instance;

    private RepositorioAlunos(int tamanho) {
        this.alunos = new Aluno[tamanho];
    }

    public static RepositorioAlunos getInstance(int tam){
        if(instance == null){
            instance = new RepositorioAlunos(tam);
        }
        return instance;
    }

    public void criarAluno(String nome, int cpf, LocalDate dataDeNascimento, String email, String senha, int idTurma){
        Aluno aluno = new Aluno();

        aluno.setId(contador.incrementAndGet());
        aluno.setNome(nome);
        aluno.setCpf(cpf);
        aluno.setDataDeNascimento(dataDeNascimento);
        aluno.setEmail(email);
        aluno.setSenha(senha);
        aluno.setIdTurma(idTurma);

        alunos[contador.get() - 1] = aluno;
    }

    public void removerAluno(int id){
        alunos.stream()
                .filter(aluno -> {aluno})
    }
}
