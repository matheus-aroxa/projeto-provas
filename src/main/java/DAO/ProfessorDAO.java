package DAO;

import java.time.LocalDate;
import java.util.List;

import models.usuarios.professor.Professor;

public interface ProfessorDAO {
// Adicione este método para buscar todos os alunos
    public List<Professor> findAll();

    public Professor criarProfessor(int id, String nome, long cpf, LocalDate dataDeNascimento, String email, String senha, int idTurma);

    public void removerProfessor(int id);
}
