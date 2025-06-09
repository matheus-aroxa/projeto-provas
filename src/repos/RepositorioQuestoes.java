package repos;

import models.Questao;

public class RepositorioQuestoes {
    private Questao[] questoes;
    private int tamanho;
    private static RepositorioQuestoes instance;

    public static RepositorioQuestoes criar(int tam){
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

    public int buscar(int id) {
        for (Questao q : this.questoes) {
            if (q.getId() == id) {
                return q.getId();
            }
        }
        return -1;
    }

    public boolean remover(int id) {
        int ID = buscar(id);
        if(ID != -1){
            this.questoes[ID] = null;
            return true;
        }
        else
            return false;
    }

    public void listar(){
        for(Questao q : this.questoes){
            System.out.println(q);
        }
    }

}
