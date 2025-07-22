package models;

import java.util.ArrayList;
import java.util.List;

import models.provas.Prova;

public class Turma {
    private int id;
    private String nome;
    private int idProfessor;
    private List<Integer> alunos;
    private List<Prova> provas;

    public Turma(int id, String nome, int professor) {
        this.id = id;
        this.nome = nome;
        idProfessor = professor;
        this.alunos = new ArrayList<>();
        this.provas = new ArrayList<>();
    }

    public Turma() {
        this.provas = new ArrayList<>();
    }

    public Turma(int id, String nome) {
        this.id = id;
        this.nome = nome;
        this.alunos = new ArrayList<>();
        this.provas = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdProfessor() {
        return idProfessor;
    }

    public void setIdProfessor(int idProfessor) {
        this.idProfessor = idProfessor;
    }

    public List<Integer> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Integer> alunos) {
        this.alunos = alunos;
    }

    public List<Prova> getProvas() {
        return provas;
    }

    public void setProvas(List<Prova> provas) {
        this.provas = provas;
    }

    public void adicionarProva(Prova prova){
        this.provas.add(prova);
    }

    public int getQuantAlunos() {
        return alunos == null ? 0 : alunos.size();
    }

    public void adicionarAluno(int idAluno) {
        if (!alunos.contains(idAluno)) {
            alunos.add(idAluno);
        }
    }
}
