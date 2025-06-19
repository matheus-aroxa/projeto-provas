package controller;

import java.time.Period;
import java.time.LocalDateTime;

import models.Turma;
import models.provas.CartaoResposta;
import models.provas.Prova;
import models.provas.Questao;
import repos.RepositorioProvas;

public class CadastroProva {
	
	public Prova cadastro(RepositorioProvas repo, int id, String titulo, String descricao, LocalDateTime dataAplicacao, Period duracao, boolean isRemoto, Turma[] turmas, Questao[] questoes, CartaoResposta[] respostas) {
		if (repo.getProvaById(id) != null) {
			return new Prova(id, titulo, descricao, dataAplicacao, duracao, isRemoto, turmas, questoes, respostas);
		}
		return null;
	}
}
