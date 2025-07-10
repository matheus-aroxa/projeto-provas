package models.provas;

import models.Turma;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;

public class Prova {
    private int id;
    private String titulo;
    private String descricao;
    private LocalDateTime dataAplicacao;
    private Duration duracao;
    private boolean isRemoto;
    private Turma[] turmas;
    private Questao[] questoes;
    private CartaoResposta[] respostas;


    public Prova() {
    }

    public Prova(int id,String titulo, String descricao, LocalDateTime dataAplicacao, Duration duracao, boolean isRemoto, Turma[] turmas, Questao[] questoes, CartaoResposta[] respostas) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataAplicacao = dataAplicacao;
        this.duracao = duracao;
        this.isRemoto = isRemoto;
        this.turmas = turmas;
        this.questoes = questoes;
        this.respostas = respostas;
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

    public Duration getDuracao() {
        return duracao;
    }

    public void setDuracao(Duration duracao) {
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
    
    public CartaoResposta[] getRespostas() {
    	return respostas;
    }
    
    public void setRespostas(CartaoResposta[] respostas) {
    	this.respostas = respostas;
    }

}
