package controller;

import models.provas.Prova;
import models.provas.Questao;

public class ControllerProva {    
    public static void removerQuestao(Prova prova, Questao questao) {
    	for (int i = 0; i < prova.getQuestoes().length; i++) {
    		if (prova.getQuestoes()[i].getId() == questao.getId()) {
    			for (int j = i; j < prova.getQuestoes().length; j++) {
    				prova.getQuestoes()[j] = prova.getQuestoes()[j + 1];
    			}
    			prova.getQuestoes()[prova.getQuestoes().length - 1] = null;
    		}
    	}
    }
}
