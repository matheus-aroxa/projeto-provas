package models.usuarios.professor;

import models.usuarios.Usuario;

import java.time.LocalDate;
import java.util.Objects;

public abstract class Professor extends Usuario {

    private int idTurma;
    private Salario salario;

    public Professor(int id, String nome, int cpf, LocalDate dataDeNascimento, String email, String senha, int idTurma) {
        super(id, nome, cpf, dataDeNascimento, email, senha);
        this.idTurma = idTurma;
    }

    public Professor(int idTurma) {
        this.idTurma = idTurma;
    }

    public int getIdTurma() {
        return idTurma;
    }

    public void setIdTurma(int idTurma) {
        this.idTurma = idTurma;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Professor professor)) return false;
        if (!super.equals(o)) return false;
        return getIdTurma() == professor.getIdTurma();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getIdTurma());
    }

    @Override
    public String toString() {
        return "Professor{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cpf=" + cpf +
                ", dataDeNascimento=" + dataDeNascimento +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", idTurma=" + idTurma +
                '}';
    }
}
