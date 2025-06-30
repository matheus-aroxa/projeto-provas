package repos;

import models.Turma;
import models.provas.CartaoResposta;
import models.provas.Prova;
import models.provas.Questao;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.concurrent.atomic.AtomicInteger;

public class RepositorioProvas {

    private Prova[] provas;
    private static AtomicInteger contador = new AtomicInteger();
    private static RepositorioProvas instance;
    private int tam;

    private RepositorioProvas(int tam) {
        this.provas = new Prova[tam];
        this.tam = 0;
    }

    public static RepositorioProvas getInstance(int tam) {
        if(instance == null) {
            instance = new RepositorioProvas(tam);
        }
        return instance;
    }

    public void adicionar(String titulo, String descricao, LocalDateTime dataAplicacao, Duration duracao, boolean isRemoto, Turma[] turmas, Questao[] questoes, CartaoResposta[] respostas) {
        provas[contador.get()] = new Prova(contador.getAndIncrement(),titulo,  descricao,  dataAplicacao,  duracao,  isRemoto, turmas,  questoes, respostas);
    }

    public Prova[] getAllProvas() {
        return provas;
    }

    public Prova procurar(int id) {
        for(int i = 0; i < tam; i++) {
            if(provas[i].getId() == id) {
                return provas[i];
            }
        }
        return null;
    }

//    public Prova getProvaByTitulo(String titulo) {
//    	for(int i = 0; i < tam; i++) {
//    		if(provas[i].getTitulo().equals(titulo)) {
//    			return provas[i];
//    		}
//    	}
//    	return null;
//    }
//
//    public Prova getProvaByData(LocalDateTime data) {
//    	for(int i = 0; i < tam; i++) {
//    		if(provas[i].getDataAplicacao().isEqual(data)) {
//    			return provas[i];
//    		}
//    	}
//    	return null;
//    }
//
//    public Prova getProvaByTipo(boolean tipo) {
//    	for(int i = 0; i < tam; i++) {
//    		if (provas[i].isRemoto() == tipo) {
//    			return provas[i];
//    		}
//    	}
//    	return null;
//    }

    public Prova remover(int id) {
        for(int i = 0; i < tam; i++) {
            if(provas[i].getId() == id) {
                Prova provaR = provas[i];
                for(int j = i; j < tam - 1; j++) {
                    provas[j] = provas[j + 1];
                }
                provas[tam - 1] = null;
                tam--;
                return provaR;
            }
        }
        return null;
    }

    public void editarProva(Prova prova) {};

}
