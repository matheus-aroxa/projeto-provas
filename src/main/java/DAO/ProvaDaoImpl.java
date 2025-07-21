package DAO;

import java.util.ArrayList;
import java.util.List;

import models.provas.Prova;
import repos.RepositorioProvas;

public class ProvaDaoImpl implements ProvaDAO {

    private RepositorioProvas repositorio = RepositorioProvas.getInstance(10);

    @Override
    public List<Prova> findAll() {
        List<Prova> listaDeProvas = new ArrayList<>();
        Prova[] todasAsProvas = repositorio.getProvas();

        for (Prova prova : todasAsProvas) {            
            listaDeProvas.add(prova);
        }
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
