package controller;

import java.time.LocalDate;

import models.usuarios.Administrador;
import repos.RepositorioUsuarios;

public class CadastroAdmin {
	
	public static Administrador cadastro(RepositorioUsuarios repo, int id, String nome, int cpf, LocalDate dataDeNascimento, String email, String senha) {
		String emailValido = "([a-zA-Z0-9\\.-_])+@([a-zA-Z])+(\\.([a-zA-Z])+)+"; //válida e-mails
		int validaCpf = String.valueOf(Math.abs(cpf)).length(); //retorna o número de dígitos do cpf
		if (repo.procurarUsuario(id) != -1
				&& email.matches(emailValido)
				&& validaCpf == 11
                && senha != null
                && dataDeNascimento != null) {
            return new Administrador(id, nome, cpf, dataDeNascimento, email, senha);
            
		}
		return null; 
	}
}
