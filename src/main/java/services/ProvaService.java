package services;

import Exceptions.ArrayIsFullException;
import Exceptions.InvalidIdException;
import Exceptions.ObjectAlreadyExistsException;
import Exceptions.ProvaNotExistsException;
import Exceptions.RequiredArgumentIsNullException;
import models.provas.Prova;
import repos.RepositorioProvas;

public class ProvaService {

    private RepositorioProvas repositorio = RepositorioProvas.getInstance(10);

    public void criarProva(Prova prova) {

    if (prova.getTitulo() == null || prova.getTitulo().isEmpty()
            || prova.getDataAplicacao() == null
            || prova.getDescricao() == null || prova.getDescricao().isEmpty()
            || prova.getDuracao() == null) {
        throw new RequiredArgumentIsNullException();
    }

    if (repositorio.getContador().get() >= repositorio.getProvas().length) {
        throw new ArrayIsFullException();
    }

    int novoId = repositorio.getContador().get() + 1;
    prova.setId(novoId);

    if (repositorio.procurar(novoId) != -1) {
        throw new ObjectAlreadyExistsException("Já existe uma prova com o ID: " + novoId);
    }

    repositorio.criarProva(prova);
    for(Prova u : repositorio.getProvas())
        System.out.println(u);
}

    public void editarProva(Prova prova) {

        if (prova == null) {
            throw new RequiredArgumentIsNullException();
        }

        if (repositorio.procurar(prova.getId()) == -1) {
            throw new ProvaNotExistsException();
        }

        if (prova.getTitulo() == null || prova.getTitulo().isEmpty()
                || prova.getDataAplicacao() == null
                || prova.getDescricao() == null || prova.getDescricao().isEmpty()
                || prova.getDuracao() == null) {
            throw new RequiredArgumentIsNullException();
        }

        repositorio.editarProva(prova);

    }

    public void removerProva(int id) {
        if(id <= 0) throw new InvalidIdException();

        if(repositorio.procurar(id) == 1) throw new ProvaNotExistsException();

        repositorio.remover(id);
        for(Prova u : repositorio.getProvas())
            System.out.println(u);
    }

}
