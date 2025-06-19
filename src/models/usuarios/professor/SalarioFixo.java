package models.usuarios.professor;

public class SalarioFixo implements Salario{
    private double valor;

    public SalarioFixo(double valor ){
        this.valor = valor;
    }

    @Override
    public double getPagamento() {
        return valor;
    }
}
