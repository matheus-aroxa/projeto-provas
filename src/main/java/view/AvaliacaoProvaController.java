package view;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import Fachada.Fachada;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import models.provas.Prova;
import models.provas.Questao;

public class AvaliacaoProvaController extends FuncoesComuns {

    private Fachada fachada;

    @FXML
    private Label labelEnunciado;

    @FXML
    private ToggleGroup alternativasGroup;
    @FXML
    private Label alternativaA,alternativaB,alternativaC,alternativaD,alternativaE;
    @FXML
    private RadioButton respostaA, respostaB, respostaC, respostaD, respostaE;
    @FXML
    private javafx.scene.control.Button btProximo, btAnterior;

    private Prova prova;
    private List<Questao> questoes;
    private int[] respostas;
    private int questaoAtual;
    private List<RadioButton> radioButtons;

    @FXML
    private void initialize() {
        radioButtons = Arrays.asList(respostaA, respostaB, respostaC, respostaD, respostaE);
    }

    public void setProva(Prova prova) {
        this.prova = prova;
        this.questoes = Arrays.asList(fachada.getQuestaoService().getQuestoesProva(prova.getId()));

        if (this.questoes != null && !this.questoes.isEmpty()) {

            this.respostas = new int[this.questoes.size()];
            Arrays.fill(this.respostas, -1);

            carregarQuestao();
        } else {
            // Tratar caso de prova sem questões
            labelEnunciado.setText("Esta prova não contém questões.");
            btAnterior.setDisable(true);
            btProximo.setDisable(true);
        }
    }

     private void carregarQuestao() {
        // Limpa a seleção anterior
        alternativasGroup.selectToggle(null);

        Questao questao = questoes.get(questaoAtual);
        
        labelEnunciado.setText(questao.getEnunciado());

        List<String> alternativas = Arrays.asList(questao.getAlternativas());
        for (int i = 0; i < radioButtons.size(); i++) {
            if (i < alternativas.size()) {
                radioButtons.get(i).setText(alternativas.get(i));
                radioButtons.get(i).setVisible(true);
            } else {
                radioButtons.get(i).setVisible(false); // Esconde rádios não utilizados
            }
        }

        // Restaura a resposta do usuário se ele já respondeu esta questão
        if (respostas[questaoAtual] != -1) {
            radioButtons.get(respostas[questaoAtual]).setSelected(true);
        }

        atualizarEstadoBotoes();
    }

    private void salvarRespostaAtual() {
        RadioButton selectedRadio = (RadioButton) alternativasGroup.getSelectedToggle();
        if (selectedRadio != null) {
            int respostaIndex = radioButtons.indexOf(selectedRadio);
            respostas[questaoAtual] = respostaIndex;
        } else {
            respostas[questaoAtual] = -1; // Nenhuma alternativa selecionada
        }
    }


    @FXML
    void handleAnterior(ActionEvent event) {
        salvarRespostaAtual();
        if (questaoAtual > 0) {
            questaoAtual--;
            carregarQuestao();
        }
    }

    @FXML
    void handleProximo(ActionEvent event) throws IOException {
        salvarRespostaAtual();

        if (questaoAtual < questoes.size() - 1) {
            // Se não for a última questão, avança
            questaoAtual++;
            carregarQuestao();
        } else {
            // Se for a última questão (botão "Finalizar"), finaliza a prova
            finalizarProva(event);
        }
    }

    private void finalizarProva(ActionEvent event) throws IOException {
        System.out.println("Prova finalizada!");
        System.out.println("Respostas salvas: " + Arrays.toString(respostas));
        
        // Aqui você pode adicionar a lógica para salvar o array 'respostas' no banco de dados
        // associado ao aluno e à prova.
        
        // Exemplo: voltando para o menu do aluno
        trocarTela(event, "AlunoDashboardView.fxml", "Menu do Aluno");
    }
    
    private void atualizarEstadoBotoes() {
        // Desabilita "Anterior" na primeira questão
        btAnterior.setDisable(questaoAtual == 0);

        // Muda o texto de "Próximo" para "Finalizar" na última questão
        if (questaoAtual == questoes.size() - 1) {
            btProximo.setText("Finalizar");
        } else {
            btProximo.setText("Próximo");
        }
    }
}
