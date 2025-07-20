package models.usuarios.professor;

import java.time.LocalDate;
import java.util.Objects;

import models.usuarios.Usuario;

public class Professor extends Usuario {

    private int idTurma;
    private Salario salario;
    private String disciplina;

    public Professor(int id, String nome, Long cpf, LocalDate dataDeNascimento, String email, String senha, Integer idTurma, String disciplina) {
        super(id, nome, cpf, dataDeNascimento, email, senha);
        this.idTurma = idTurma;
        this.disciplina = disciplina;
    }

    public Professor(Integer idTurma) {
        this.idTurma = idTurma;
    }

    public Professor(int idTurma) {
        this.idTurma = idTurma;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public String getDisciplina() {
        return this.disciplina;
    }

    public Integer getIdTurma() {
        return idTurma;
    }

    public void setIdTurma(Integer idTurma) {
        this.idTurma = idTurma;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Professor professor)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        return getIdTurma() == professor.getIdTurma();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getIdTurma());
    }

    @Override

    public String toString() {
        return "Professor{"
                + "id=" + id
                + ", nome='" + nome + '\''
                + ", cpf=" + cpf
                + ", dataDeNascimento=" + dataDeNascimento
                + ", email='" + email + '\''
                + ", senha='" + senha + '\''
                + ", idTurma=" + idTurma
                + ", disciplina=" + disciplina
                + '}';
    }
}
