package repos;

import models.provas.Prova;
import models.provas.Questao;

public class RepositorioQuestoes {
    private Questao[] questoes;
    private int tamanho;
    private static RepositorioQuestoes instance;

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

    public void adicionar(Questao questao) {
        if(tamanho < questoes.length) {
            this.questoes[this.tamanho] = questao;
            this.tamanho++;
        }
    }

    public Questao buscar(int id) {
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

    public void editarEnunciado(Questao questao, String enu){ questao.setEnunciado(enu);}

    public void editarAlternativas(Questao questao, int[] id){ questao.setIdAlternativas(id);} // isso aqui ta zoado

}
