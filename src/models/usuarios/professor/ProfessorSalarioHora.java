package models.usuarios.professor;

import java.time.LocalDate;

public class ProfessorSalarioHora extends Professor{
    private double salario;
    private int horas;

    public ProfessorSalarioHora(int id, String nome, long cpf, LocalDate dataDeNascimento, String email, String senha, int idTurma,double salario, int horas) {
        super(id, nome, cpf, dataDeNascimento, email, senha, idTurma);
        this.salario = salario;
        this.horas = horas;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    @Override
    public double getPagamento() {
        return horas * salario;
    }
}
