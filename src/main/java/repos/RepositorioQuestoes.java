package repos;

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
        questoes[contador.get()] = new Questao(contador.getAndIncrement(),questao.getIdProva(), questao.getEnunciado(), questao.getAlternativas());
    }

    public void editar(Questao questao) {
        int posicao = procurar(questao.getId());
        if(posicao != -1){
            Questao questaoExistente = questoes[posicao];
            
            questaoExistente.setEnunciado(questao.getEnunciado());
            questaoExistente.setAlternativa(questao.getAlternativas());

        }
    }

    public Questao[] getQuestoes() {
        return questoes;
    }

    public AtomicInteger getContador() {
        return contador;
    }

    public int procurar(int id) {
        for (Questao q : this.questoes) {
            if (q.getId() == id) {
                return q.getId();
            }
        }
        return -1;
    }

    public void remover(int id) {
        int busca = procurar(id);
        if(busca == -1) return;

        for(int i = 0; i < questoes.length;i++)
            questoes[i] = questoes[i + 1];
        
        questoes[questoes.length -1 ] = null;
    }

    public Questao[] listar() {
        return questoes;
    }

}
