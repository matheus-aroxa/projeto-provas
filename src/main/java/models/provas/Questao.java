package models.provas;

import java.util.Arrays;

public class Questao {
    private int id;
    private String enunciado;
    private Integer[] idAlternativas;

    public Questao(int id, String enunciado, Integer[] idAlternativas) {
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

    public Integer[] getIdAlternativas() {
        return idAlternativas;
    }

    public void setIdAlternativas(Integer[] idAlternativas) {
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
    
    public void editarEnunciado(Questao questao, String enu){ questao.setEnunciado(enu);}

    public void editarAlternativas(Questao questao, Integer[] id){ questao.setIdAlternativas(id);} // isso aqui ta zoado
}
