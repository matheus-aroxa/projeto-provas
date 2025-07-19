package view;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class ProfessorDashboardController extends FuncoesComuns {

    @FXML
    private AnchorPane contentArea;

    @FXML
    private Label tabTitle;

    @FXML
    void irTelaAdmController(ActionEvent event) throws IOException {
        trocarTela(event, "ProfessorDashboardView.fxml", "Menu do professor");
    }

    public void usuarios(ActionEvent event) throws IOException {
        trocarAba(contentArea, "GerenciarUsuariosView.fxml");
    }

    public void provas(ActionEvent event) throws IOException {
        trocarAba(contentArea, "");
    }

    public void notas(ActionEvent event) throws IOException {
        trocarAba(contentArea, "");
    }

    public void relatorios(ActionEvent event) throws IOException {
        trocarAba(contentArea, "");
    }

    public void notificacoes(ActionEvent event) throws IOException {
        trocarAba(contentArea, "");
    }
}
