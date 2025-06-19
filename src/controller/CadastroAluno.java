package controller;

import java.time.LocalDate;

import models.usuarios.Aluno;
import repos.RepositorioUsuarios;

public class CadastroAluno {
	
	public static Aluno cadastro(RepositorioUsuarios repo, int id, String nome, long cpf, LocalDate dataDeNascimento, String email, String senha, int idTurma) {
		String emailValido = "([a-zA-Z0-9\\.-_])+@([a-zA-Z])+(\\.([a-zA-Z])+)+"; //válida e-mails
        int validaCpf = String.valueOf(Math.abs(cpf)).length(); //retorna o número de dígitos do cpf
		if (repo.procurarUsuario(id) == -1
				&& email.matches(emailValido)
				&& validaCpf == 11
				&& senha != null
				&& dataDeNascimento != null) {
			return new Aluno(id, nome, cpf, dataDeNascimento, email, senha, idTurma);
        }
		return null;
	}
}
