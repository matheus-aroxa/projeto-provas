package models.usuarios.professor;

import java.time.LocalDate;

public class ProfessorSalarioFixo extends Professor implements Salario{
    private double salario;

    public ProfessorSalarioFixo(int id, String nome, long cpf, LocalDate dataDeNascimento, String email, String senha, int idTurma,double salario) {
        super(id, nome, cpf, dataDeNascimento, email, senha, idTurma);
        this.salario = salario;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public double getPagamento() {
        return salario;
    }
}
