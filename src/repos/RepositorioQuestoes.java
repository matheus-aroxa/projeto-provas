package repos;

import models.provas.Questao;

import java.util.concurrent.atomic.AtomicInteger;

public class RepositorioQuestoes {

    private Questao[] questoes;
    private static AtomicInteger contador = new AtomicInteger();
    private static RepositorioQuestoes instance;
    private int tamanho;

    public static RepositorioQuestoes getInstance(int tam){
        if(instance == null){
            instance = new RepositorioQuestoes(tam);
        }
            return instance;
    }

    private RepositorioQuestoes(int tamanho) {
        this.questoes = new Questao[tamanho];
        this.tamanho = 0;
    }

    public void adicionar(String enunciado, int[] idAlternativas) {
        questoes[contador.get()] = new Questao(contador.getAndIncrement(),enunciado,idAlternativas);
    }

    public Questao procurar(int id) {
        for (Questao q : this.questoes) {
            if (q.getId() == id) {
                return q;
            }
        }
        return null;
    }

    public Questao remover(int id) {
        for (int i = 0; i < tamanho; i++) {
            if (questoes[i].getId() == id) {
                Questao questR = questoes[i];
                for (int j = i; j < tamanho - 1; j++) {
                    questoes[j] = questoes[j + 1];
                }
                questoes[tamanho - 1] = null;
                tamanho--;
                return questR;
            }
        }
        return null;
    }

    public Questao[] listar(){
       return questoes;
    }

    public void editar(Questao quest){};


}
