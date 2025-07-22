package DAO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import models.Turma;
import repos.RepositorioTurmas;

public class TurmaDAOlmpl implements ObjectDAO<Turma>{
    private final RepositorioTurmas repositorio = RepositorioTurmas.getInstance(100);

    public List<Turma> findAll() {
        Turma[] listaDeTurmas = repositorio.getAllTurmas();
        if (listaDeTurmas != null) {
            return Arrays.asList(listaDeTurmas);
        } else {
            return new ArrayList<>();
        }
    }

    public Turma criar(String nome, int idProfessor){
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

    @Override
    public Turma criar(Turma t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'criar'");
    }
    
}
