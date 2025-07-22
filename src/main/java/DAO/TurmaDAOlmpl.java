package DAO;

import models.Turma;
import models.usuarios.Aluno;
import models.usuarios.Usuario;
import models.usuarios.professor.Professor;
import repos.RepositorioTurmas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TurmaDAOlmpl implements ObjectDAO<Turma>{
    private final RepositorioTurmas repositorio = RepositorioTurmas.getInstance(100);

    public List<Turma> getAllTurmas() {
        Turma[] listaDeTurmas = repositorio.getAllTurmas();
        if (listaDeTurmas != null) {
            return Arrays.asList(listaDeTurmas);
        } else {
            return new ArrayList<>();
        }
    }

    public Turma adicionar(String nome, int idProfessor){
        repositorio.adicionar(nome, idProfessor);
        return null;
    }

    public Turma add(String nome){
        repositorio.add(nome);
        return null;
    }

    public void remover(int id){
        repositorio.remover(id);
    }
}
