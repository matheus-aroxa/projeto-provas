package DAO;

import models.usuarios.Aluno;

import java.time.LocalDate;

public interface AlunoDAO {

    public Aluno criarAluno(int id, String nome, int cpf, LocalDate dataDeNascimento, String email, String senha, int idTurma);

    public void removerAluno(int id);

}
