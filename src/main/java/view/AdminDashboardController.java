package view;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class AdminDashboardController extends FuncoesComuns {

    @FXML
    private AnchorPane contentArea;

    @FXML
    private Label tabTitle;

    @FXML
    void irTelaAdmController(ActionEvent event) throws IOException {
        trocarTela(event, "AdminDashboardView.fxml", "Menu do Administrador");
    }

    public void usuarios(ActionEvent event) throws IOException {
        trocarAba(contentArea, "GerenciarUsuariosView.fxml");
    }

    public void alunos(ActionEvent event) throws IOException {
        trocarAba(contentArea, "GerenciarAlunosView.fxml");
    }

    public void professores(ActionEvent event) throws IOException {
        trocarAba(contentArea, "GerenciarProfessoresView.fxml");
    }

    public void turmas(ActionEvent event) throws IOException {
        trocarAba(contentArea, "paneTurmaAdm.fxml");
    }

    public void settings(ActionEvent event) throws IOException {
        trocarAba(contentArea, "paneSettingsAdm.fxml");
    }
}
