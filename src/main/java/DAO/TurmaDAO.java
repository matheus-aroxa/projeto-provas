package DAO;

import models.Turma;

public interface TurmaDAO {

    public Turma[] getAllTurmas();

    public Turma adicionar(Turma turma);

    public void remover(int id);
}
