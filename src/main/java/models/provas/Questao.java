package models.provas;

import java.util.Arrays;

public class Questao {
    private int id;
    private int idProva;
    private int idResposta;
    private String enunciado;
    private String[] alternativas;

    public Questao(int id, int idProva, String enunciado, String[] alternativas,int idResposta) {
        this.id = id;
        this.idProva = idProva;
        this.enunciado = enunciado;
        this.alternativas = alternativas;
        this.idResposta = idResposta ;
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

    public int getIdResposta(){
        return this.idResposta;
    }

    public void setIdResposta(int idResposta){
        this.idResposta = idResposta;
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

    public void setAlternativas(String[] alternativas) {
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
