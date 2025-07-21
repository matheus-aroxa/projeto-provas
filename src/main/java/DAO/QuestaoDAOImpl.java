package DAO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import models.provas.Questao;
import repos.RepositorioQuestoes;

public class QuestaoDAOImpl implements ObjectDAO<Questao>{

    private final RepositorioQuestoes repositorio = RepositorioQuestoes.getInstance(10);

    @Override
    public List<Questao> findAll() {
        List<Questao> listaDeQuestoes = new ArrayList<>();
        listaDeQuestoes.addAll(Arrays.asList(repositorio.getQuestoes()));
        return listaDeQuestoes;    
    }

    @Override
    public Questao criar(Questao questao) {
        return null;
    }

    @Override
    public void remover(int id) {
        repositorio.remover(id);
    }

}
