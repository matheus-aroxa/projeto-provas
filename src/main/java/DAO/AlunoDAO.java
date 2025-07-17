package DAO;

import models.usuarios.Aluno;
import java.time.LocalDate;
import java.util.List; // Importe a classe List

public interface AlunoDAO {

    // Adicione este método para buscar todos os alunos
    public List<Aluno> findAll();

    public Aluno criarAluno(int id, String nome, long cpf, LocalDate dataDeNascimento, String email, String senha, int idTurma);

    public void removerAluno(int id);
}