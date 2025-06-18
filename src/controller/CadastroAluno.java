package controller;

import java.time.LocalDate;

import models.usuarios.Aluno;
import repos.RepositorioUsuarios;

public class CadastroAluno {
	
	public Aluno cadastrar(RepositorioUsuarios repo, int id, String nome, int cpf, LocalDate dataDeNascimento, String email, String senha, int idTurma) {
		if (repo.procurarUsuario(id) != -1) {
			String emailValido = "([a-zA-Z0-9\\.-_])+@([a-zA-Z])+(\\.([a-zA-Z])+)+"; //válida e-mails
            if(email.matches(emailValido)) {   //email é valido
            	return new Aluno(id, nome, cpf, dataDeNascimento, email, senha, idTurma);
            }	
        }
		return null;
	}
}
