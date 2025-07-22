package view.cadastro;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;

import Fachada.Fachada;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import models.provas.Prova;
import view.FuncoesComuns;
import view.GerenciarQuestoesController;

public class CadastroProvaController extends FuncoesComuns {

    private Prova prova;
    

    @FXML
    TextField campoTitulo;
    @FXML
    TextArea campoDescricao;
    @FXML
    DatePicker campoData;
    @FXML
    RadioButton btRemoto;
    @FXML
    TextField campoDuracao;
    @FXML
    RadioButton btPresencial;
    
    private Fachada fachada = Fachada.getInstance();
    
    public CadastroProvaController(){
        this.fachada = Fachada.getInstance();
    }

    public void setProva(Prova prova) {
        this.prova = prova;
        preencherCampos();
    }

    private void preencherCampos() {
        if (prova != null) {
            campoTitulo.setText(prova.getTitulo());
            campoDescricao.setText(prova.getDescricao());
            campoData.setValue(prova.getDataAplicacao().toLocalDate());
            campoDuracao.setText(String.valueOf(prova.getDuracao().toHours()));

            if (prova.getIsRemoto()) {
                btRemoto.setSelected(true);
            } else {
                btPresencial.setSelected(true);
            }
        }
    }

    @FXML
    void cancelar(ActionEvent evento) throws IOException {
        trocarTela(evento, "/view/ProfessorDashboardView.fxml", "Gerenciamento de Provas");
    }

    @FXML
    void proximo(ActionEvent evento) throws IOException {
        try {
            Duration duracao = Duration.ofHours(Long.parseLong(campoDuracao.getText()));
            LocalDateTime data = campoData.getValue().atStartOfDay();
            boolean remoto = btRemoto.isSelected();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/GerenciarQuestoesView.fxml"));
            Parent page = loader.load();
            GerenciarQuestoesController controlador = loader.getController();

            if (campoTitulo.getText().isEmpty() || campoDescricao.getText().isEmpty()
                    || campoData.getValue() == null || campoDuracao.getText().isEmpty()) {
                throw new Exception("Preencha todos os campos obrigatórios");
            }

            if (prova == null) {

                Prova novaProva = new Prova(
                        0,
                        campoTitulo.getText(),
                        campoDescricao.getText(),
                        data,
                        duracao,
                        remoto
                );
                fachada.getProvaService().criarProva(novaProva);
                controlador.setProva(novaProva);
            } else {
                prova.setTitulo(campoTitulo.getText());
                prova.setDescricao(campoDescricao.getText());
                prova.setDataAplicacao(data);
                prova.setDuracao(duracao);
                prova.setIsRemoto(remoto);

                fachada.getProvaService().editarProva(prova);
                controlador.setProva(prova);
            }
            Stage janela = (Stage) ((Node) evento.getSource()).getScene().getWindow();
            janela.setScene(new Scene(page));
            janela.setTitle("Gerenciamento de Questões");
        } catch (Exception e) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setContentText("Erro ao salvar prova: " + e.getMessage());
            alerta.setHeaderText("Erro no cadastro");
            alerta.show();
            e.printStackTrace();
        }
    }

}
