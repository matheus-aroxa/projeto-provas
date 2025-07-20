package services;

import java.time.LocalDate;

import Exceptions.ArrayIsFullException;
import Exceptions.InvalidIdException;
import Exceptions.ObjectAlreadyExistsException;
import Exceptions.RequiredArgumentIsNullException;
import Exceptions.UserNotExistsException;
import models.usuarios.Aluno;
import models.usuarios.Usuario;
import models.usuarios.professor.Professor;
import repos.RepositorioUsuarios;

public class UsuarioService {

    private RepositorioUsuarios repositorio = RepositorioUsuarios.getInstance(10);

    public void criarAluno(Aluno aluno) {
        if (aluno.getNome() == null || aluno.getNome().isEmpty()
                || aluno.getCpf() == null
                || aluno.getDataDeNascimento() == null
                || aluno.getEmail() == null || aluno.getEmail().isEmpty()
                || aluno.getSenha() == null || aluno.getSenha().isEmpty()
                || aluno.getIdTurma() == null) {
            throw new RequiredArgumentIsNullException();
        }

        if (repositorio.procurarUsuario(repositorio.getContador().get() + 1) != -1) {
            throw new ObjectAlreadyExistsException("Não foi possível criar usuário com id: " + (repositorio.getContador().get() + 1));
        }

        if (repositorio.getContador().get() >= 10) {
            throw new ArrayIsFullException();
        }

        repositorio.criarAluno(aluno);

        for (Usuario u : repositorio.getUsuarios()) {
            System.out.println(u);
        }
        System.out.println("--------------------");
    }

    public void criarProfessor(Professor professor) {
        if (professor.getNome() == null || professor.getNome().isEmpty()
                || professor.getCpf() == null
                || professor.getDataDeNascimento() == null
                || professor.getEmail() == null || professor.getEmail().isEmpty()
                || professor.getSenha() == null || professor.getSenha().isEmpty()
                || professor.getIdTurma() == null
                || professor.getDisciplina() == null || professor.getDisciplina().isEmpty()) {
            throw new RequiredArgumentIsNullException();
        }

        if (repositorio.procurarUsuario(repositorio.getContador().get() + 1) != -1) {
            throw new ObjectAlreadyExistsException("Não foi possível criar usuário com id: " + (repositorio.getContador().get() + 1));
        }

        //verificar se tem espaço no array
        if (repositorio.getContador().get() >= 10) {
            throw new ArrayIsFullException();
        }

        repositorio.criarProfessor(professor);

        for (Usuario u : repositorio.getUsuarios()) {
            System.out.println(u);
        }
        System.out.println("--------------------");
    }

    public void criarAdministrador(String nome, Long cpf, LocalDate dataDeNascimento, String email, String senha) {
        if (nome == null || cpf == null || dataDeNascimento == null || email == null || senha == null) {
            throw new RequiredArgumentIsNullException();
        }

        if (repositorio.procurarUsuario(repositorio.getContador().get() + 1) != -1) {
            throw new ObjectAlreadyExistsException("Não foi possível criar usuário com id: " + (repositorio.getContador().get() + 1));
        }

        //verificar se tem espaço no array
        if (repositorio.getContador().get() >= 10) {
            throw new ArrayIsFullException();
        }

        repositorio.criarAdministrador(nome, cpf, dataDeNascimento, email, senha);

        for (Usuario u : repositorio.getUsuarios()) {
            System.out.println(u);
        }
        System.out.println("--------------------");
    }

    public void editarAluno(Aluno aluno) {
        if (aluno == null) {
            throw new RequiredArgumentIsNullException();
        }

        if (repositorio.procurarUsuario(aluno.getId()) == -1) {
            throw new UserNotExistsException();
        }

        if (aluno.getNome() == null || aluno.getNome().isEmpty()
                || aluno.getCpf() == null
                || aluno.getDataDeNascimento() == null
                || aluno.getEmail() == null || aluno.getEmail().isEmpty()
                || aluno.getSenha() == null || aluno.getSenha().isEmpty()
                || aluno.getIdTurma() == null) {
            throw new RequiredArgumentIsNullException();
        }
        repositorio.editarAluno(aluno);
    }

    public void editarProfessor(Professor professor){
        if(professor == null){
            throw new RequiredArgumentIsNullException();
        }

        if (repositorio.procurarUsuario(professor.getId()) == -1) {
            throw new UserNotExistsException();
        }

        if (professor.getNome() == null || professor.getNome().isEmpty()
                || professor.getCpf() == null
                || professor.getDataDeNascimento() == null
                || professor.getEmail() == null || professor.getEmail().isEmpty()
                || professor.getSenha() == null || professor.getSenha().isEmpty()
                || professor.getIdTurma() == null
                || professor.getDisciplina() == null || professor.getDisciplina().isEmpty()) {
                
            throw new RequiredArgumentIsNullException();
        }
        repositorio.editarProfessor(professor);
    
    }

    public void removerUsuario(int id) {
        if (id <= 0) {
            throw new InvalidIdException();
        }

        if (repositorio.procurarUsuario(id) == -1) {
            throw new UserNotExistsException();
        }

        repositorio.removerUsuario(id);
        for (Usuario u : repositorio.getUsuarios()) {
            System.out.println(u);
        }
    }

    public void procurarUsuario(int id) {
        if (id <= 0) {
            throw new InvalidIdException();
        }

        repositorio.procurarUsuario(id);
    }
}
