package DAO;

import models.Turma;

import java.util.List;

public interface TurmaDAO {

    public List<Turma> getAllTurmas();

    public Turma adicionar(String nome, int idProfessor);

    public Turma add(String nome);

    public void remover(int id);
}
