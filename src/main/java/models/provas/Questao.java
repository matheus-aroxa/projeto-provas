package models.provas;

import java.util.Arrays;

public class Questao {
    private int id;
    private int idProva;
    private String enunciado;
    private String[] alternativas;

    public Questao(int id, int idProva, String enunciado, String[] alternativas) {
        this.id = id;
        this.idProva = idProva;
        this.enunciado = enunciado;
        this.alternativas = alternativas;
    }

    public Questao() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdProva() {
        return idProva;
    }

    public void setIdProva(int id) {
        this.idProva = id;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public String[] getAlternativas() {
        return alternativas;
    }

    public void setAlternativa(String[] alternativas) {
        this.alternativas = alternativas;
    }

    @Override
    public String toString() {
        return "Questão{" +
                "id=" + id +
                ", enunciado='" + enunciado + '\'' +
                ", alternativas=" + Arrays.toString(alternativas) +
                '}';
    }
    
}
