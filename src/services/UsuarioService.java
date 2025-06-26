package services;

import java.time.LocalDate;

import Exceptions.RequiredArgumentIsNullException;
import Exceptions.UserAlreadyExistsException;
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
		
		
	}
}
