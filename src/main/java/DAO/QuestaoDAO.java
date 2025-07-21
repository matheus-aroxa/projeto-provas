package DAO;

import java.util.List;

import models.provas.Prova;
import models.provas.Questao;

public interface QuestaoDAO {
    public List<Questao> findAll();

    public Prova criarQuestao(Questao questao);

    public void removerQuestao(int id);
}
