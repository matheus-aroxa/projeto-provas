package controller;

import models.usuarios.professor.Professor;
import repos.RepositorioUsuarios;

import java.time.LocalDate;


public class CadastroProfessor{

    public Professor cadastro(RepositorioUsuarios repo,int id, String nome, int cpf, LocalDate dataDeNascimento, String email, String senha, int idTurma){
        if(repo.procurarUsuario(id) != -1){
            String emailValido = "([a-zA-Z0-9\\.-_])+@([a-zA-Z])+(\\.([a-zA-Z])+)+"; //válida e-mails
            if(email.matches(emailValido)){   //email é valido
                //validar cpf
                //validar se a turma existe
                return new Professor(id,nome,cpf,dataDeNascimento,email,senha,idTurma);
            }
        }
        return null;
    }
}
