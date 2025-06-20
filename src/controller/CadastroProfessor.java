package controller;

import models.usuarios.professor.Professor;
import models.usuarios.professor.ProfessorSalarioFixo;
import models.usuarios.professor.ProfessorSalarioHora;
import repos.RepositorioUsuarios;

public class CadastroProfessor{

    public static Professor cadastro(RepositorioUsuarios repositorio, ProfessorSalarioFixo professor) {
    	String emailValido = "([a-zA-Z0-9\\.-_])+@([a-zA-Z])+(\\.([a-zA-Z])+)+"; //válida e-mails
        int validaCpf = String.valueOf(Math.abs(professor.getCpf())).length(); //retorna o número de dígitos do cpf
        if(repositorio.procurarUsuario(professor.getId()) == -1
        		&& professor.getEmail().matches(emailValido)
        		&& validaCpf == 11
        		&& professor.getSenha() != null
        		&& professor.getDataDeNascimento() != null
        		&& professor.getSalario() > 0) {
        	return new ProfessorSalarioFixo(professor.getId(), professor.getNome(), professor.getCpf(), professor.getDataDeNascimento(), professor.getEmail(), professor.getSenha(), professor.getIdTurma(), professor.getSalario());
        }
        return null;
    }
    
    public static Professor cadastro(RepositorioUsuarios repositorio, ProfessorSalarioHora professor) {
    	String emailValido = "([a-zA-Z0-9\\.-_])+@([a-zA-Z])+(\\.([a-zA-Z])+)+"; //válida e-mails
        int validaCpf = String.valueOf(Math.abs(professor.getCpf())).length(); //retorna o número de dígitos do cpf
    	if(repositorio.procurarUsuario(professor.getId()) == -1
    			&& professor.getEmail().matches(emailValido)
    			&& validaCpf == 11
    			&& professor.getSenha() != null
    			&& professor.getDataDeNascimento() != null
    			&& professor.getSalario() > 0
    			&& professor.getHoras() > 0) {
    		return new ProfessorSalarioHora(professor.getId(), professor.getNome(), professor.getCpf(), professor.getDataDeNascimento(), professor.getEmail(), professor.getSenha(), professor.getIdTurma(), professor.getSalario(), professor.getHoras());
    	}
    	return null;
    }
}
