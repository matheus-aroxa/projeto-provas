package services;

import java.time.LocalDate;

import Exceptions.ArrayIsFullException;
import Exceptions.RequiredArgumentIsNullException;
import Exceptions.UserAlreadyExistsException;
import models.usuarios.Usuario;
import repos.RepositorioQuestoes;

public class QuestaoService {
	
	private RepositorioQuestoes repositorio = RepositorioQuestoes.getInstance(10);
	
	public void criarQuestao(Integer id, String enunciado, Integer[] idAlternativas) {
		if (id == null || enunciado == null || idAlternativas == null) {
			throw new RequiredArgumentIsNullException();
		}
		
		if(repositorio.getContador().get() >= 10){
			throw new ArrayIsFullException();
		}
		
//		repositorio.criarAluno(nome, cpf, dataDeNascimento, email, senha, idTurma);
//
//		for(Usuario u : repositorio.get){
//			System.out.println(u);
//		}
//		System.out.println("--------------------");
	}
	/*
	 	public void criarAluno(String nome, Long cpf, LocalDate dataDeNascimento, String email, String senha, Integer idTurma) {
		if (nome == null || cpf == null || dataDeNascimento == null || email == null || senha == null || idTurma == null) {
			throw new RequiredArgumentIsNullException();
		}
		
		if (repositorio.procurarUsuario(repositorio.getContador().get() + 1) != -1) {
			throw new UserAlreadyExistsException("Não foi possível criar usuário com id: " + (repositorio.getContador().get() + 1));
		}

		//verificar se tem espaço no array
		if(repositorio.getContador().get() >= 10){
			throw new ArrayIsFullException();
		}

		repositorio.criarAluno(nome, cpf, dataDeNascimento, email, senha, idTurma);

		for(Usuario u : repositorio.getUsuarios()){
			System.out.println(u);
		}
		System.out.println("--------------------");
	} 
	*/
}
