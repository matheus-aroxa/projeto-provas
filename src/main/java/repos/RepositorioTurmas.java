package repos;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import models.Turma;

public class RepositorioTurmas {

    private Turma[] turmas;
    private static AtomicInteger contador = new AtomicInteger();
    private static RepositorioTurmas instance;

    private RepositorioTurmas(int t) {
        this.turmas = new Turma[t];
    }

    public static RepositorioTurmas getInstance(int tam) {
        if (instance == null) {
            instance = new RepositorioTurmas(tam);
        }
        return instance;
    }

    public void adicionar(String nome, int professor) {
        turmas[contador.get()] = new Turma(contador.getAndIncrement(), nome, professor);
    }

    public void add(String nome) {
        int proximoId = contador.get();
        if (proximoId < turmas.length) {
            turmas[proximoId] = new Turma(proximoId, nome);
            contador.incrementAndGet();
        }
    }

    public Turma procurarPorId(int id) {
        for(int i = 0; i < contador.get(); i++) {
            if(turmas[i] != null && turmas[i].getId() == id){
                return turmas[i];
            }
        }
        return null;
    }

    public Turma procurar(int id) {
        for (int i = 0; i < turmas.length; i++) {
            if (turmas[i].getId() == id) {
                return turmas[i];
            }
        }
        return null;
    }

    public Turma buscarAlunoPorId(int id) {
        for (int i = 0; i < turmas.length; i++) {
            if (turmas[i].getId() == id) {
                return turmas[i];
            }
        }
        return null;
    }

    public List<Turma> listarTodas() {
        return Arrays.stream(turmas)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    public Turma[] getAllTurmas() {
        if (turmas != null) {
            return turmas;
        }
        return null;
    }

    public Turma remover(int id) {
        for (int i = 0; i < turmas.length; i++) {
            if (turmas[i] != null || turmas[i].getId() == id) {
                Turma ex = turmas[i];
                for (int j = i; j < turmas.length - 1; j++) {
                    turmas[j] = turmas[j + 1];
                }
                turmas[turmas.length - 1] = null;
                return ex;
            }
        }
        return null;
    }
}
