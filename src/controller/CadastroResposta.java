package controller;

import models.provas.CartaoResposta;
import repos.RepositorioProvas;

public class CadastroResposta {
	
	public CartaoResposta cadastro(RepositorioProvas repo, int id, int[] resposta, int idAluno, int idProva) {
		if (repo.getProvaById(idProva) != null) {
			return new CartaoResposta(id, resposta, idAluno, idProva);
		}
		return null;
	}
}
