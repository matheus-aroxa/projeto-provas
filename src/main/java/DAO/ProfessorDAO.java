package DAO;

import java.util.List;

import models.usuarios.professor.Professor;

public interface ProfessorDAO {
// Adicione este método para buscar todos os alunos
    public List<Professor> findAll();

    public Professor criarProfessor(Professor professor);

    public void removerProfessor(int id);
}
