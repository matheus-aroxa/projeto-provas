package controller;

import models.provas.Prova;
import models.provas.Questao;

public class ControllerProva {    
    public void removerQuestao(Prova Prova, Questao questao) {
    	for (int i = 0; i < Prova.getQuestoes().length; i++) {
    		if (Prova.getQuestoes()[i].getId() == questao.getId()) {
    			for (int j = i; j < Prova.getQuestoes().length; j++) {
    				Prova.getQuestoes()[j] = Prova.getQuestoes()[j + 1];
    			}
    			Prova.getQuestoes()[Prova.getQuestoes().length - 1] = null;
    		}
    	}
    }
}
