package repos;

import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

import models.provas.Questao;

public class RepositorioQuestoes {

    private Questao[] questoes;
    private static AtomicInteger contador = new AtomicInteger();
    private static RepositorioQuestoes instance;

    private RepositorioQuestoes(int tamanho) {
        this.questoes = new Questao[tamanho];
    }

    public static RepositorioQuestoes getInstance(int tam) {
        if (instance == null) {
            instance = new RepositorioQuestoes(tam);
        }
        return instance;
    }

    public void criarQuestao(Questao questao) {
        int proximoIndice = contador.getAndIncrement();
        this.questoes[proximoIndice] = questao;
    }

    public void editar(Questao questao) {
        int posicao = procurar(questao.getId());
        if (posicao != -1) {
            Questao questaoExistente = questoes[posicao];

            questaoExistente.setEnunciado(questao.getEnunciado());
            questaoExistente.setAlternativas(questao.getAlternativas());
            questaoExistente.setIdResposta(questao.getIdResposta());

        }
    }

    public Questao[] getQuestoes() {
        return questoes;
    }

    public AtomicInteger getContador() {
        return contador;
    }

    public int procurar(int id) {
        for (int i = 0; i < questoes.length; i++) {
            if (questoes[i] != null && questoes[i].getId() == id) {
                return i;
            }
        }
        return -1;
    }

    public void remover(int id) {
        int pos = procurar(id);
        if (pos == -1) {
            return;
        }

        for (int i = pos; i < questoes.length - 1; i++) {
            questoes[i] = questoes[i + 1];
        }
        questoes[questoes.length - 1] = null;
        contador.decrementAndGet();
    }

    public Questao[] listar() {
        return Arrays.stream(questoes)
                .filter(Objects::nonNull)
                .toArray(Questao[]::new);
    }

    public int getProximoId() {
        return contador.get();
    }

}
