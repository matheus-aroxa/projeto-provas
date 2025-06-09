package models.usuarios;

import java.time.LocalDate;

public class Aluno extends Usuario {

    private int idTurma;

    public Aluno(int id, String nome, int cpf, LocalDate dataDeNascimento, String email, String senha, int idTurma) {
        super(id, nome, cpf, dataDeNascimento, email, senha);
        this.idTurma = idTurma;
    }

    public Aluno(int idTurma) {
        this.idTurma = idTurma;
    }

    public Aluno() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(LocalDate dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdTurma() {
        return idTurma;
    }

    public void setIdTurma(int idTurma) {
        this.idTurma = idTurma;
    }
}
