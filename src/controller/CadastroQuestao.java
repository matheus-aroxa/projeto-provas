package controller;

import models.provas.Questao;
import repos.RepositorioQuestoes;

public class CadastroQuestao {
	
	public static Questao cadastro(RepositorioQuestoes repositorio, Questao questao) {
		if(repositorio.buscar(questao.getId()) == null
				&& questao.getEnunciado() != null
				&& questao.getIdAlternativas().length == 5) {
			return new Questao(questao.getId(), questao.getEnunciado(), questao.getIdAlternativas());
		}
		return null;
	}
}
