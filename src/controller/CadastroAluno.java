package controller;

import models.usuarios.Aluno;
import repos.RepositorioUsuarios;

public class CadastroAluno {
	
	public static Aluno cadastro(RepositorioUsuarios repositorio, Aluno aluno) {
		String emailValido = "([a-zA-Z0-9\\.-_])+@([a-zA-Z])+(\\.([a-zA-Z])+)+"; //válida e-mails
        int validaCpf = String.valueOf(Math.abs(aluno.getCpf())).length(); //retorna o número de dígitos do cpf
        if(repositorio.procurarUsuario(aluno.getId()) == -1
        		&& aluno.getEmail().matches(emailValido)
        		&& validaCpf == 11
        		&& aluno.getSenha() != null
        		&& aluno.getDataDeNascimento() != null) {
        	return new Aluno(aluno.getId(), aluno.getNome(), aluno.getCpf(), aluno.getDataDeNascimento(), aluno.getEmail(), aluno.getSenha(), aluno.getIdTurma());
        }
		return null;
	}
}
