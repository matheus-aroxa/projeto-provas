package DAO;

import java.util.List;

import models.usuarios.Aluno;

public interface AlunoDAO {

    // Adicione este método para buscar todos os alunos
    public List<Aluno> findAll();

    public Aluno criarAluno(Aluno aluno);

    public void removerAluno(int id);
}