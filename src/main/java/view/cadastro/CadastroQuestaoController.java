package view.cadastro;

import java.io.IOException;

import Fachada.Fachada;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import models.provas.Prova;
import models.provas.Questao;
import services.QuestaoService;
import view.FuncoesComuns;
import view.GerenciarQuestoesController;

public class CadastroQuestaoController extends FuncoesComuns {

    private Fachada fachada;

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

    @FXML
    RadioButton respostaA;
    @FXML
    RadioButton respostaB;
    @FXML
    RadioButton respostaC;
    @FXML
    RadioButton respostaD;
    @FXML
    RadioButton respostaE;

    private RadioButton[] respostas;
    private TextField[] campos;

    private Prova prova;
    private Questao questao;

    @FXML
    public void initialize() {
        respostas = new RadioButton[]{respostaA, respostaB, respostaC, respostaD, respostaE};
        campos = new TextField[]{campoA, campoB, campoC, campoD, campoE};
    }

    public void setProva(Prova prova) {
        this.prova = prova;
        System.out.println(prova);
    }

    public void setQuestao(Questao questao) {
        this.questao = questao;
        preencherCampos();
    }

    private void preencherCampos() {
        if (questao != null) {
            String[] alternativas = questao.getAlternativas();
            campoEnunciado.setText(questao.getEnunciado());

            for (int i = 0; i < campos.length && i < alternativas.length; i++) {
                campos[i].setText(alternativas[i]);
            }

            for (int i = 0; i < respostas.length; i++) {
                respostas[i].setSelected(questao.getIdResposta() == i);
            }

        }
    }

    @FXML
    void voltar(ActionEvent evento) throws IOException {
        trocarTela(evento, "/view/ProfessorDashboardView.fxml", "Gerenciamento de Questões");
    }

    @FXML
    void cadastrar(ActionEvent evento) throws IOException {
        try {
            if (respostas == null || campos == null) {
                initialize();
            }

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/GerenciarQuestoesView.fxml"));
            Parent page = loader.load();
            GerenciarQuestoesController controlador = loader.getController();


            String[] alternativas = new String[campos.length];
            for (int i = 0; i < campos.length; i++) {
                alternativas[i] = campos[i].getText();
            }

            int resposta = -1;
            for (int i = 0; i < respostas.length; i++) {
                if (respostas[i].isSelected()) {
                    resposta = i;
                    break;
                }
            }

            if (resposta == -1) {
                throw new Exception("Selecione a resposta correta");
            }

            if (questao == null) {
                Questao novaQuestao = new Questao(0, prova.getId(), campoEnunciado.getText(), alternativas, resposta);
                fachada.getQuestaoService().criarQuestao(novaQuestao);
                
            } else {
                questao.setEnunciado(campoEnunciado.getText());
                questao.setAlternativas(alternativas);
                questao.setIdResposta(resposta);
                fachada.getQuestaoService().editarQuestao(questao);
            }
            controlador.setProva(prova);
            Stage janela = (Stage) ((Node) evento.getSource()).getScene().getWindow();
            janela.setScene(new Scene(page));
            janela.setTitle("Gerenciamento de Questões");
            

        } catch (Exception e) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setContentText("Erro ao salvar questão: " + e.getMessage());
            alerta.setHeaderText("Erro no cadastro");
            alerta.show();
            e.printStackTrace();
        }
    }
}

