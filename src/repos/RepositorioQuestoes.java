package repos;

import models.Questao;

public class RepositorioQuestoes {
    private Questao[] questoes;
    private int tamanho;
    private static RepositorioQuestoes instance;

    public static RepositorioQuestoes criaRepositorio(int tam){
        if(instance == null){
            instance = new RepositorioQuestoes(tam);
        }
            return instance;
    }

    private RepositorioQuestoes(int tamanho) {
        this.questoes = new Questao[tamanho];
        this.tamanho = 0;
    }

    public boolean adicionarQuestao(Questao questao) {
        if(tamanho < questoes.length) {
            this.questoes[this.tamanho] = questao;
            this.tamanho++;
            return true;
        }else
            return false;
    }

    public int buscarQuestao(int id) {
        for (Questao q : this.questoes) {
            if (q.getId() == id) {
                return q.getId();
            }
        }
        return -1;
    }

    public boolean removerQuestao(int id) {
        int ID = buscarQuestao(id);
        if(ID != -1){
            this.questoes[ID] = null;
            return true;
        }
        else
            return false;
    }

    public void listarQuestoes(){
        for(Questao q : this.questoes){
            System.out.println(q);
        }
    }

}
