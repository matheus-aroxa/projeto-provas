package controller;

import models.usuarios.professor.Professor;
import models.usuarios.professor.ProfessorSalarioFixo;
import models.usuarios.professor.ProfessorSalarioHora;
import repos.RepositorioUsuarios;
import java.time.LocalDate;


public class CadastroProfessor{

    public static Professor cadastro(RepositorioUsuarios repo, int id, String nome, int cpf, LocalDate dataDeNascimento, String email, String senha, int idTurma,double salario) {
        String emailValido = "([a-zA-Z0-9\\.-_])+@([a-zA-Z])+(\\.([a-zA-Z])+)+"; //válida e-mails
        int validaCpf = String.valueOf(Math.abs(cpf)).length(); //retorna o número de dígitos do cpf
        if(repo.procurarUsuario(id) != -1
                && email.matches(emailValido)
                && validaCpf == 11
                && senha != null
                && dataDeNascimento != null
                && salario > 0) {
            return new ProfessorSalarioFixo(id, nome, cpf, dataDeNascimento, email, senha, idTurma,salario);
        }
        return null;
    }

    public static Professor cadastro(RepositorioUsuarios repo, int id, String nome, int cpf, LocalDate dataDeNascimento, String email, String senha, int idTurma,double salario,int horas) {
        String emailValido = "([a-zA-Z0-9\\.-_])+@([a-zA-Z])+(\\.([a-zA-Z])+)+"; //válida e-mails
        int validaCpf = String.valueOf(Math.abs(cpf)).length(); //retorna o número de dígitos do cpf
        if(repo.procurarUsuario(id) != -1
                && email.matches(emailValido)
                && validaCpf == 11
                && senha != null
                && dataDeNascimento != null
                && salario > 0
                && horas > 0) {
            return new ProfessorSalarioHora(id, nome, cpf, dataDeNascimento, email, senha, idTurma, salario, horas);
        }
        return null;
    }
}
