package repos;

import models.Turma;

public class RepositorioTurmas {
    private Turma[] turmas;
    private int tam;
    private static RepositorioTurmas instance;

    public static RepositorioTurmas getInstance(int tam) {
        if(instance == null){instance = new RepositorioTurmas(tam);}
        return instance;
    }

    private RepositorioTurmas(int t) {
        this.turmas = new Turma[t];
        this.tam = 0;
    }

    public void createTurma(Turma turma) {
        if (tam < turmas.length) {
            this.turmas[this.tam] = turma;
            this.tam++;
        }
    }

    public Turma getTurma(int id) {
        for(int i = 0; i < turmas.length; i++) {
            if(turmas[i].getId() == id){
                return turmas[i];
            }
        }
        return null;
    }

    public Turma[] getAllTurmas() {
        return turmas;
    }

    public Turma deleteTurma(int id) {
        for(int i = 0; i < turmas.length; i++) {
            if(turmas[i].getId() == id) {
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

    public void updateTurma(Turma turma){};
}
