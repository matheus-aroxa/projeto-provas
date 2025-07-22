package repos;

import models.Turma;
import models.usuarios.professor.Professor;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.atomic.AtomicInteger;

import models.Turma;

public class RepositorioTurmas {
    private Turma[] turmas;
    private static AtomicInteger contador = new AtomicInteger();
    private static RepositorioTurmas instance;
    private int tam;

    private RepositorioTurmas(int t) {
        this.turmas = new Turma[t];
        this.tam = 0;
    }

    public static RepositorioTurmas getInstance(int tam) {
        if(instance == null){instance = new RepositorioTurmas(tam);}
        return instance;
    }

    public void adicionar( String nome, int professor) {
        turmas[contador.get()] = new Turma(contador.getAndIncrement(),nome,professor);
    }

    public void add(String nome) {
        turmas[contador.get()] = new Turma(contador.getAndIncrement(),nome);
    }

    public Turma procurar(int id) {
        for(int i = 0; i < turmas.length; i++) {
            if(turmas[i].getId() == id){
                return turmas[i];
            }
        }
        return null;
    }

    public Turma buscarAlunoPorId(int id) {
        for (int i = 0; i < tam; i++) {
            if (turmas[i].getId() == id) {
                return turmas[i];
            }
        }
        return null;
    }

    public Turma[] getAllTurmas() {
        if(turmas != null) {
            return turmas;
        }
        return null;
    }

    public Turma remover(int id) {
        for(int i = 0; i < tam; i++) {
            if(turmas[i] != null || turmas[i].getId() == id) {
                Turma ex = turmas[i];
                for(int j = i; j < tam - 1; j++) {
                    turmas[j] = turmas[j + 1];
                }
                turmas[tam-1] = null;
                tam--;
                return ex;
            }
        }
        return null;
    }
}
