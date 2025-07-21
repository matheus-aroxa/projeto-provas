package DAO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import models.provas.Prova;
import repos.RepositorioProvas;

public class ProvaDAOImpl implements ObjectDAO<Prova> {

    private final RepositorioProvas repositorio = RepositorioProvas.getInstance(10);

    @Override
    public List<Prova> findAll() {
        List<Prova> listaDeProvas = new ArrayList<>();
        Prova[] todasAsProvas = repositorio.getProvas();

        listaDeProvas.addAll(Arrays.asList(todasAsProvas));
        
        return listaDeProvas;
    }

    @Override
    public Prova criar(Prova prova) {
        return null;
    }

    @Override
    public void remover(int id) {
        repositorio.remover(id);
    }

}
