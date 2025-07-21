package view;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import models.provas.Prova;
import models.provas.Questao;
import services.QuestaoService;

public class AvaliacaoProvaController extends FuncoesComuns {

    @FXML
    private Label labelEnunciado;
    @FXML
    private ToggleGroup alternativasGroup;
    @FXML
    private Label alternativaA, alternativaB, alternativaC, alternativaD, alternativaE;
    @FXML
    private RadioButton respostaA, respostaB, respostaC, respostaD, respostaE;
    @FXML
    private Button btProximo, btAnterior;

    private Prova prova;
    private List<Questao> questoes;
    private int[] respostas;
    private int questaoAtual = 0;

    private List<RadioButton> radioButtons;
    private List<Label> alternativeLabels;

    @FXML
    private void initialize() {
        radioButtons = Arrays.asList(respostaA, respostaB, respostaC, respostaD, respostaE);
        alternativeLabels = Arrays.asList(alternativaA, alternativaB, alternativaC, alternativaD, alternativaE); // ADICIONADO
    }

    public void setProva(Prova prova) {
        this.prova = prova;
        QuestaoService questaoService = new QuestaoService();
        this.questoes = Arrays.asList(questaoService.getQuestoesProva(prova.getId()));

        if (this.questoes != null && !this.questoes.isEmpty()) {
            this.respostas = new int[this.questoes.size()];
            Arrays.fill(this.respostas, -1);
            carregarQuestao();
        } else {
            labelEnunciado.setText("Esta prova não contém questões.");
            btAnterior.setDisable(true);
            btProximo.setDisable(true);

            for (int i = 0; i < radioButtons.size(); i++) {
                radioButtons.get(i).setVisible(false);
                alternativeLabels.get(i).setVisible(false);
            }
        }
    }

    private void carregarQuestao() {
        if (alternativasGroup.getSelectedToggle() != null) {
            alternativasGroup.getSelectedToggle().setSelected(false);
        }

        Questao questao = questoes.get(questaoAtual);
        labelEnunciado.setText(questao.getEnunciado());

        String[] alternativas = questao.getAlternativas();

        for (int i = 0; i < alternativeLabels.size(); i++) {
            if (i < alternativas.length) {
                alternativeLabels.get(i).setText(alternativas[i]);
                alternativeLabels.get(i).setVisible(true);
                radioButtons.get(i).setVisible(true);
            } else {
                alternativeLabels.get(i).setVisible(false);
                radioButtons.get(i).setVisible(false);
            }
        }

        if (respostas[questaoAtual] != -1) {
            radioButtons.get(respostas[questaoAtual]).setSelected(true);
        }

        atualizarEstadoBotoes();
    }

    private void salvarRespostaAtual() {
        RadioButton selectedRadio = (RadioButton) alternativasGroup.getSelectedToggle();
        if (selectedRadio != null) {
            respostas[questaoAtual] = radioButtons.indexOf(selectedRadio);
        } else {
            respostas[questaoAtual] = -1;
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
            questaoAtual++;
            carregarQuestao();
        } else {
            finalizarProva(event);
        }
    }

    private void finalizarProva(ActionEvent event) throws IOException {
        System.out.println("Prova finalizada!");
        System.out.println("Respostas salvas: " + Arrays.toString(respostas));
        trocarTela(event, "AlunoDashboardView.fxml", "Menu do Aluno");
    }

    private void atualizarEstadoBotoes() {
        btAnterior.setDisable(questaoAtual == 0);
        btProximo.setText(questaoAtual == questoes.size() - 1 ? "Finalizar" : "Próxima");
    }
}
