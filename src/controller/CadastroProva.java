package controller;

import models.provas.Prova;
import repos.RepositorioProvas;

public class CadastroProva {
	
	public static Prova cadastro(RepositorioProvas repositorio, Prova prova) {
		if(repositorio.getProvaById(prova.getId()) == null
				&& prova.getTitulo() != null
				&& prova.getDataAplicacao() != null
				&& prova.getDuracao() != null) {
			return new Prova(prova.getId(), prova.getTitulo(), prova.getDescricao(), prova.getDataAplicacao(), prova.getDuracao(), prova.isRemoto(), prova.getTurmas(), prova.getQuestoes(), prova.getRespostas());
		}
		return null;
	}
}
