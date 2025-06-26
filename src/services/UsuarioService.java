package services;

import java.time.LocalDate;

import Exceptions.*;
import models.usuarios.Usuario;
import repos.RepositorioUsuarios;

public class UsuarioService {
	
	private RepositorioUsuarios repositorio = RepositorioUsuarios.getInstance(10);
	
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

	public void criarProfessor(String nome, Long cpf, LocalDate dataDeNascimento, String email, String senha, Integer idTurma) {
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

	public void criarAdministrador(String nome, Long cpf, LocalDate dataDeNascimento, String email, String senha, Integer idTurma) {
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

	public void removerUsuario(int id){
		if(id <= 0){
			throw new InvalidIdException();
		}

		if(repositorio.procurarUsuario(id) == -1){
			throw new UserNotExistsException();
		}

		repositorio.removerUsuario(id);
		for(Usuario u : repositorio.getUsuarios()){
			System.out.println(u);
		}
	}

	public void procurarUsuario(int id){
		if(id <= 0){
			throw new InvalidIdException();
		}

		repositorio.procurarUsuario(id);
	}
}
