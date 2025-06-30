package services;

import Exceptions.ArrayIsFullException;
import Exceptions.RequiredArgumentIsNullException;
import Exceptions.ObjectAlreadyExistsException;
import models.provas.Questao;
import repos.RepositorioQuestoes;

public class QuestaoService {
	
	private RepositorioQuestoes repositorio = RepositorioQuestoes.getInstance(10);
	
	public void criarQuestao(Integer id, String enunciado, Integer[] idAlternativas) {
		if (id == null || enunciado == null || idAlternativas == null) {
			throw new RequiredArgumentIsNullException();
		}
		
		if (repositorio.procurar(repositorio.getContador().get() + 1) != null) {
			throw new ObjectAlreadyExistsException("Não foi possível criar usuário com id: " + (repositorio.getContador().get() + 1));
		}
		
		if(repositorio.getContador().get() >= 10){
			throw new ArrayIsFullException();
		}
		
		repositorio.adicionar(enunciado, idAlternativas);
		
		for(Questao q : repositorio.getAllQuestoes()) {
			System.out.println(q);
		}
		System.out.println("---------------------------");
	}
}
