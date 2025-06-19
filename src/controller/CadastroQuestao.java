package controller;

import models.provas.Questao;
import repos.RepositorioQuestoes;

public class CadastroQuestao {
	
	public static Questao cadastro(RepositorioQuestoes repo, int id, String enunciado, int[] idAlternativas) {
		if (repo.buscar(id) == null
				&& enunciado != null
				&& idAlternativas.length == 5) {
			return new Questao(id, enunciado, idAlternativas);
		}
		return null;
	}
}
