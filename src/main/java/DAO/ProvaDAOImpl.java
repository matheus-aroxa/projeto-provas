package DAO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import models.provas.Prova;
import repos.RepositorioProvas;

public class ProvaDAOImpl implements ProvaDAO {

    private final RepositorioProvas repositorio = RepositorioProvas.getInstance(10);

    @Override
    public List<Prova> findAll() {
        List<Prova> listaDeProvas = new ArrayList<>();
        Prova[] todasAsProvas = repositorio.getProvas();

        listaDeProvas.addAll(Arrays.asList(todasAsProvas));
        
        return listaDeProvas;
    }

    @Override
    public Prova criarProva(Prova prova) {
        return null;
    }

    @Override
    public void removerProva(int id) {
        repositorio.remover(id);
    }

}
