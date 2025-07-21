package DAO;

import java.util.ArrayList;
import java.util.List;

import models.provas.Prova;
import models.provas.Questao;
import repos.RepositorioQuestoes;

public class QuestaoDAOImpl implements QuestaoDAO{

    private final RepositorioQuestoes repositorio = RepositorioQuestoes.getInstance(10);

    @Override
    public List<Questao> findAll() {
        List<Questao> listaDeQuestoes = new ArrayList<>();
        Questao[] todasAsQuestoes = repositorio.getQuestoes();    
        return listaDeQuestoes;    
    }

    @Override
    public Prova criarQuestao(Questao questao) {
        return null;
    }

    @Override
    public void removerQuestao(int id) {
        repositorio.remover(id);
    }

}
