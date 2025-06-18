package controller;

import java.time.LocalDate;

import models.usuarios.Administrador;
import repos.RepositorioUsuarios;

public class CadastroAdmin {
	
	public Administrador cadastro(RepositorioUsuarios repo, int id, String nome, int cpf, LocalDate dataDeNascimento, String email, String senha) {
		if (repo.procurarUsuario(id) != -1) {
			String emailValido = "([a-zA-Z0-9\\.-_])+@([a-zA-Z])+(\\.([a-zA-Z])+)+"; //válida e-mails
            if(email.matches(emailValido)) {   //email é valido
            	return new Administrador(id, nome, cpf, dataDeNascimento, email, senha);
            }
		}
		return null; 
	}
}
