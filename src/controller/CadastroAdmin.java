package controller;

import models.usuarios.Administrador;
import repos.RepositorioUsuarios;

public class CadastroAdmin {
	
	public static Administrador cadastro(RepositorioUsuarios repositorio, Administrador admin) {
		String emailValido = "([a-zA-Z0-9\\.-_])+@([a-zA-Z])+(\\.([a-zA-Z])+)+"; //válida e-mails
		int validaCpf = String.valueOf(Math.abs(admin.getCpf())).length(); //retorna o número de dígitos do cpf
		if(repositorio.procurarUsuario(admin.getId()) == -1
				&& admin.getEmail().matches(emailValido)
				&& validaCpf == 11
				&& admin.getSenha() != null
				&& admin.getDataDeNascimento() != null) {
			return new Administrador(admin.getId(), admin.getNome(), admin.getCpf(), admin.getDataDeNascimento(), admin.getEmail(), admin.getSenha());
			
		}
		return null;
	}
}
