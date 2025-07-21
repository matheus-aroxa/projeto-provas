package view.cadastro;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import models.provas.Prova;
import models.provas.Questao;
import view.FuncoesComuns;

public class CadastroQuestaoController extends FuncoesComuns {

    @FXML
    TextArea campoEnunciado;

    @FXML
    TextField campoA;
    @FXML
    TextField campoB;
    @FXML
    TextField campoC;
    @FXML
    TextField campoD;
    @FXML
    TextField campoE;

    private Prova prova;
    private Questao questao;

    public void setProva(Prova prova) {
        this.prova = prova;
    }

    public void setQuestao(Questao questao) {
        this.questao = questao;
        preencherCampos();
    }

    private void preencherCampos() {
        if (questao != null) {
            String[] alternativas = questao.getAlternativas();
            campoEnunciado.setText(questao.getEnunciado());

            campoA.setText(alternativas[0]);
            campoB.setText(alternativas[1]);
            campoC.setText(alternativas[2]);
            campoD.setText(alternativas[3]);
            campoE.setText(alternativas[4]);
        }
    }

    @FXML
    void voltar(ActionEvent evento) throws IOException {
        trocarTela(evento, "/view/ProfessorDashboardView.fxml", "Gerenciamento de Questões");
    }

    @FXML
    void cadastrar(ActionEvent evento) throws IOException {
        try {

            String[] alternativas = {campoA.getText(),
                campoB.getText(),
                campoC.getText(),
                campoD.getText(),
                campoE.getText()};

            if (questao == null) {
                Questao novaQuestao = new Questao(0, prova.getId(), campoEnunciado.getText(), alternativas);
            } else {
                questao.setEnunciado(campoEnunciado.getText());
                questao.setAlternativa(alternativas);
            }
        } catch (Exception e) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setContentText("Erro ao salvar prova: " + e.getMessage());
            alerta.setHeaderText("Erro no cadastro");
            alerta.show();
            e.printStackTrace();
        }

        trocarTela(evento, "/view/GerenciarQuestoesView.fxml", "Gerenciamento de Questões");
    }
}
