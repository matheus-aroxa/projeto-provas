package DAO;

import models.Turma;
import models.usuarios.professor.Professor;

public interface TurmaDAO {

    public Turma[] getAllTurmas();

    public Turma adicionar(Turma turma);

    public void remover(int id);
}
