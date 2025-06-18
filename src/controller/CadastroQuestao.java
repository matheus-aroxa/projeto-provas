package controller;

import models.provas.Questao;
import repos.RepositorioQuestoes;

public class CadastroQuestao {
	
	public Questao cadastro(RepositorioQuestoes repo, int id, String enunciado, int[] idAlternativas) {
		if (repo.buscar(id) != null) {
			return new Questao(id, enunciado, idAlternativas);
		}
		return null;
	}
}
