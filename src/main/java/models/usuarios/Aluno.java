package models.usuarios;

import java.time.LocalDate;
import java.util.Objects;

public class Aluno extends Usuario {

    private Integer idTurma;

    public Aluno(int id, String nome, Long cpf, LocalDate dataDeNascimento, String email, String senha, Integer idTurma) {
        super(id, nome, cpf, dataDeNascimento, email, senha);
        this.idTurma = idTurma;
    }

    public Aluno() {
    }

    public Integer getIdTurma() {
        return idTurma;
    }

    public void setIdTurma(Integer idTurma) {
        this.idTurma = idTurma;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Aluno aluno)) return false;
        if (!super.equals(o)) return false;
        return getIdTurma() == aluno.getIdTurma();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getIdTurma());
    }


    @Override

    public String toString() {
        return "Aluno{" +
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
