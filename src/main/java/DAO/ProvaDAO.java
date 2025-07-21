package DAO;

import java.util.List;

import models.provas.Prova;

public interface ProvaDAO {
    public List<Prova> findAll();

    public Prova criarProva(Prova prova);

    public void removerProva(int id);
}
