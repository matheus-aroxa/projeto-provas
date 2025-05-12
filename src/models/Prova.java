package models;

import java.time.LocalDateTime;
import java.time.Period;

public class Prova {
    private int id;
    private String titulo;
    private String descricao;
    private LocalDateTime dataAplicacao;
    private Period duracao;
    private boolean isRemoto; //ainda tô em dúvida de como implementar esse atributo
    private Turma[] turmas;
    private Questao[] questoes;


    public Prova() {
    }

    public Prova(int id,String titulo, String descricao, LocalDateTime dataAplicacao, Period duracao, boolean isRemoto,Turma[] turmas,Questao[] questoes) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataAplicacao = dataAplicacao;
        this.duracao = duracao;
        this.isRemoto = isRemoto;
        this.turmas = turmas;
        this.questoes = questoes;
    }

    public int getId(){
        return this.id;
    }

    public void setId(int id){
        this.id = id;
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

    public Period getDuracao() {
        return duracao;
    }

    public void setDuracao(Period duracao) {
        this.duracao = duracao;
    }

    public boolean isRemoto() {
        return isRemoto;
    }

    public void setIsRemoto(boolean isRemoto) {
        this.isRemoto = isRemoto;
    }

    public Turma[] getTurmas(){
        return this.turmas;
    }

    public void setTurmas(Turma[] turmas){
        this.turmas = turmas;
    }

    public Questao[] getQuestoes() {
        return questoes;
    }

    public void setQuestoes(Questao[] questoes) {
        this.questoes = questoes;
    }

    /*  adicionar após a criação da classe questão
    public Questao[] getQuestoes(){
        return this.questoes;
    }

    public void setQuestoes(Questao[] questoes){
        this.questoes = questoes;
    }*/
}
