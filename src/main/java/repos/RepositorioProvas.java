package repos;

import java.util.concurrent.atomic.AtomicInteger;

import models.provas.Prova;

public class RepositorioProvas {

    private Prova[] provas;
    private static AtomicInteger contador = new AtomicInteger();
    private static RepositorioProvas instance;

    private RepositorioProvas(int tam) {
        this.provas = new Prova[tam];
    }

    public static RepositorioProvas getInstance(int tam) {
        if (instance == null) {
            instance = new RepositorioProvas(tam);
        }
        return instance;
    }

    public AtomicInteger getContador() {
        return contador;
    }

    public void criarProva(Prova prova) {
        provas[contador.get()] = new Prova(contador.getAndIncrement(), prova.getTitulo(), prova.getDescricao(), prova.getDataAplicacao(),
                prova.getDuracao(), prova.getIsRemoto());
    }

    public void editarProva(Prova prova) {
        int posicao = procurar(prova.getId());
        if (posicao != -1) {
            Prova provaExistente = provas[posicao];

            provaExistente.setTitulo(prova.getTitulo());
            provaExistente.setDescricao(prova.getDescricao());
            provaExistente.setDataAplicacao(prova.getDataAplicacao());
            provaExistente.setDuracao(prova.getDuracao());
            provaExistente.setIsRemoto(prova.getIsRemoto());
            provaExistente.setQuestoes(prova.getQuestoes());
        }
    }

    public Prova[] getProvas() {
        return provas;
    }

    public int procurar(int id) {
        for (int i = 0; i < provas.length; i++) {
            if (provas[i] != null && provas[i].getId() == id) {
                return i;
            }
        }
        return -1;
    }

    public void remover(int id) {
        int busca = procurar(id);

        if (busca == -1) {
            return;
        }

        for (int i = 0; i < provas.length - 1; i++) {
            provas[i] = provas[i + 1];
        }
        provas[provas.length - 1] = null;
    }

}
