package view;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class AlunoDashboardController extends FuncoesComuns {

    @FXML
    private AnchorPane contentArea;

    @FXML
    private Label tabTitle;

    @FXML
    void irTelaAdmController(ActionEvent event) throws IOException {
        trocarTela(event, "AlunoDashboardView.fxml", "Menu do aluno");
    }

    public void usuarios(ActionEvent event) throws IOException {
        trocarAba(contentArea, "GerenciarUsuariosView.fxml");
    }

    public void provas(ActionEvent event) throws IOException {
        trocarAba(contentArea, "EscolhaProvaView.fxml");
    }

    public void notas(ActionEvent event) throws IOException {
        trocarAba(contentArea, "");
    }

    public void feedback(ActionEvent event) throws IOException {
        trocarAba(contentArea, "");
    }

    public void notificacoes(ActionEvent event) throws IOException {
        trocarAba(contentArea, "");
    }
}
