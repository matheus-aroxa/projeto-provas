package models.usuarios.professor;

public class SalarioHora implements Salario {
    private double valor;
    private int horas;

    public SalarioHora(int horas,double valor){
        this.valor = valor;
        this.horas = horas;
    }

    @Override
    public double getPagamento() {
        return horas * valor;
    }
}
