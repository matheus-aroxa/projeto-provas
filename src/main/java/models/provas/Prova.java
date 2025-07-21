package models.provas;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Arrays;

import models.Turma;

public class Prova {

    private int id;
    private String titulo;
    private String descricao;
    private LocalDateTime dataAplicacao;
    private Duration duracao;
    private boolean isRemoto;
    private String tipo;
    private Turma[] turmas;
    private Questao[] questoes;
    private CartaoResposta[] respostas;

    public Prova() {
    }

    public Prova(int id, String titulo, String descricao, LocalDateTime dataAplicacao, Duration duracao, boolean isRemoto) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataAplicacao = dataAplicacao;
        this.duracao = duracao;
        this.isRemoto = isRemoto;
        this.turmas = new Turma[0];
        this.questoes = new Questao[0];
        this.respostas = new CartaoResposta[0];
    }

    public Prova(int id, String titulo, String descricao, LocalDateTime dataAplicacao, Duration duracao, boolean isRemoto, Turma[] turmas, Questao[] questoes, CartaoResposta[] respostas) {
        this(id, titulo, descricao, dataAplicacao, duracao, isRemoto);
        this.turmas = turmas;
        this.questoes = questoes;
        this.respostas = respostas;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
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

    public boolean getIsRemoto() {
        return isRemoto;
    }

    public void setIsRemoto(boolean isRemoto) {
        this.isRemoto = isRemoto;
    }

    public String getTipo() {
        return isRemoto == true ? "Remoto" : "Presencial";
    }

    public Turma[] getTurmas() {
        return this.turmas;
    }

    public void setTurmas(Turma[] turmas) {
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

    @Override
    public String toString() {
        return "Prova [id=" + id + ", titulo=" + titulo + ", descricao=" + descricao + ", dataAplicacao="
                + dataAplicacao + ", duracao=" + duracao + ", isRemoto=" + isRemoto + ", tipo=" + tipo + ", turmas="
                + Arrays.toString(turmas) + ", questoes=" + Arrays.toString(questoes) + ", respostas="
                + Arrays.toString(respostas) + "]";
    }

}
