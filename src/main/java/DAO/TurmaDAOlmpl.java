package DAO;

import models.Turma;
import models.usuarios.Aluno;
import models.usuarios.Usuario;
import models.usuarios.professor.Professor;
import repos.RepositorioTurmas;

import java.util.ArrayList;
import java.util.List;

public class TurmaDAOlmpl implements TurmaDAO{
    private final RepositorioTurmas repositorio = RepositorioTurmas.getInstance(100);

    public Turma[] getAllTurmas() {
        Turma[] listaDeTurmas = null;
        listaDeTurmas = repositorio.getAllTurmas();
        return listaDeTurmas;
    }

    public Turma adicionar(Turma turma){
        repositorio.adicionar(turma.getNome(), turma.getIdProfessor());
        return null;
    }

    public void remover(int id){
        repositorio.remover(id);
    }
}
