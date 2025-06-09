package models.provas;

import java.util.Arrays;

public class Questao {
    private int id;
    private String enunciado;
    private int[] idAlternativas;

    public Questao(int id, String enunciado, int[] idAlternativas) {
        this.id = id;
        this.enunciado = enunciado;
        this.idAlternativas = idAlternativas;
    }

    public Questao() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public int[] getIdAlternativas() {
        return idAlternativas;
    }

    public void setIdAlternativas(int[] idAlternativas) {
        this.idAlternativas = idAlternativas;
    }

    @Override
    public String toString() {
        return "Questão{" +
                "id=" + id +
                ", enunciado='" + enunciado + '\'' +
                ", idAlternativas=" + Arrays.toString(idAlternativas) +
                '}';
    }
}
