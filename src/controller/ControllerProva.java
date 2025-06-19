package controller;

import models.provas.Prova;
import models.provas.Questao;

public class ControllerProva {    
    public void removerQuestao(Prova Prova, Questao questao) {
    	Questao[] questoes = Prova.getQuestoes();
    	for (int i = 0; i < questoes.length; i++) {
    		if (questoes[i].getId() == questao.getId()) {
    			for (int j = i; j < questoes.length; j++) {
    				questoes[j] = questoes[j + 1];
    			}
    			questoes[questoes.length - 1] = null;
    		}
    	}
    }
}
