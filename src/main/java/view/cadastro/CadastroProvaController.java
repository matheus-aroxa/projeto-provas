package view.cadastro;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import models.provas.Prova;
import services.ProvaService;
import view.FuncoesComuns;

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

    public void setProva(Prova prova) {
        this.prova = prova;
        preencherCampos();
    }

    private void preencherCampos() {
        if (prova != null) {
            campoTitulo.setText(prova.getTitulo());
            campoDescricao.setText(prova.getDescricao());
            campoData.setValue(prova.getDataAplicacao().toLocalDate());
            campoDuracao.setText(prova.getDuracao().toString());
            if (prova.getIsRemoto()) {
                btRemoto.setSelected(true);
                btPresencial.setDisable(true);
            } else {
                btPresencial.setSelected(true);
                btRemoto.setDisable(true);
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
            Duration duracao = Duration.ofHours(Integer.valueOf(campoDuracao.getText()));
            LocalDateTime data = campoData.getValue().atStartOfDay();
            boolean remoto = btRemoto.isSelected();

            ProvaService provaService = new ProvaService();

            if (prova == null) {
                // Cria nova prova com arrays vazios
                Prova novaProva = new Prova(
                        0, // ID temporário, será definido pelo serviço
                        campoTitulo.getText(),
                        campoDescricao.getText(),
                        data,
                        duracao,
                        remoto
                );
                provaService.criarProva(novaProva);
            } else {
                // Edição da prova existente
                prova.setTitulo(campoTitulo.getText());
                prova.setDescricao(campoDescricao.getText());
                prova.setDataAplicacao(data);
                prova.setDuracao(duracao);
                prova.setIsRemoto(remoto);

                provaService.editarProva(prova);
            }
            trocarTela(evento, "/view/GerenciarQuestoesView.fxml", "Gerenciamento de Questões");
        } catch (Exception e) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setContentText("Erro ao salvar prova: " + e.getMessage());
            alerta.setHeaderText("Erro no cadastro");
            alerta.show();
            e.printStackTrace();
        }
    }

}
