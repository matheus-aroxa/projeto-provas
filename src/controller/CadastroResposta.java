package controller;

import models.provas.CartaoResposta;
import repos.RepositorioProvas;
import repos.RepositorioUsuarios;

public class CadastroResposta {
	
	public static CartaoResposta cadastro(RepositorioProvas repoP, RepositorioUsuarios repoA, CartaoResposta resposta) {
		if(repoP.getProvaById(resposta.getIdProva()) != null
				&& repoA.procurarUsuario(resposta.getIdAluno()) == -1
				&& resposta.getResposta() != null) {
			return new CartaoResposta(resposta.getId(), resposta.getResposta(), resposta.getIdAluno(), resposta.getIdProva());
		}
		return null;
	}
}
