package controller;

import models.provas.CartaoResposta;
import repos.RepositorioProvas;
import repos.RepositorioUsuarios;

public class CadastroResposta {
	
	public static CartaoResposta cadastro(RepositorioProvas repoP, RepositorioUsuarios repoA, int id, int[] resposta, int idAluno, int idProva) {
		if (repoP.getProvaById(idProva) != null
				&& repoA.procurarUsuario(idAluno) == -1
				&& resposta != null) {
			return new CartaoResposta(id, resposta, idAluno, idProva);
		}
		return null;
	}
}
