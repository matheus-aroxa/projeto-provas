package models;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class Prova {
    private String titulo;
    private String descricao;
    private LocalDateTime dataAplicacao;
    private LocalTime duracao;
    private boolean tipoProva; //ainda tô em dúvida de como implementar esse atributo
    //private Turma[] turmasDestino;


    public Prova() {
        this.titulo = "<indefinido>";
        this.descricao = "<indefinido>";
        this.dataAplicacao = LocalDateTime.of(0,1,1,0,0); //data indefinida
        this.duracao = LocalTime.of(0,0);
        this.tipoProva = false;
    }

    public Prova(String titulo, String descricao, LocalDateTime dataAplicacao, LocalTime duracao, boolean tipoProva) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataAplicacao = dataAplicacao;
        this.duracao = duracao;
        this.tipoProva = tipoProva;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDateTime getDataAplicacao() {
        return dataAplicacao;
    }

    public void setDataAplicacao(LocalDateTime dataAplicacao) {
        this.dataAplicacao = dataAplicacao;
    }

    public LocalTime getDuracao() {
        return duracao;
    }

    public void setDuracao(LocalTime duracao) {
        this.duracao = duracao;
    }

    public boolean isTipoProva() {
        return tipoProva;
    }

    public void setTipoProva(boolean tipoProva) {
        this.tipoProva = tipoProva;
    }
}
