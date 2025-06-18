package repos;

import models.provas.Prova;

import java.time.LocalDateTime;
import java.time.Period;

public class RepositorioProvas {
    private Prova[] provas;
    private int tam;
    private static RepositorioProvas instance;

    public static RepositorioProvas getInstance(int tam){
        if (instance == null){
            instance = new RepositorioProvas(tam);
        }
        return instance;
    }

    private RepositorioProvas(int tam){
    	this.provas = new Prova[tam];
    	this.tam = 0;
    }

    public void adicionar(Prova prova){
        if(tam < provas.length) {
            this.provas[this.tam] = prova;
            this.tam++;
        }
    }

    public Prova[] getAllProvas() {
        return provas;
    }

    public Prova getProvaById(int id){
        for(int i = 0;i < tam; i++){
            if(provas[i].getId() == id){
                return provas[i];
            }
        }
        return null;
    }

    public Prova deletar(int id) {
        for (int i = 0; i < tam; i++) {
            if (provas[i].getId() == id) {
                Prova provaR = provas[i];
                for (int j = i; j < tam - 1; j++) {
                    provas[j] = provas[j + 1];
                }
                provas[tam - 1] = null;
                tam--;
                return provaR;
            }
        }
        return null;
    }

    public void editarDescricao(Prova prova, String des){ prova.setDescricao(des);}

    public void editarTitulo(Prova prova, String tit){ prova.setTitulo(tit);}

    public void editarDuracao(Prova prova, Period dur){ prova.setDuracao(dur);}

    public void editarData(Prova prova, LocalDateTime data){ prova.setDataAplicacao(data);}

    public void editarTipo(Prova prova, boolean type){ prova.setIsRemoto(type);}
}
