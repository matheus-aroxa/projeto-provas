package view;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ProfessorDashboardController extends FuncoesComuns{

    @FXML
    private Stage janela;
    @FXML
    private Scene aba;
    @FXML
    private Parent root;

    @FXML
    private AnchorPane contentArea;

    @FXML
    private Label tabTitle;

    @FXML
    void irTelaAdmController (ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ProfessorDashboardView.fxml"));
        janela = (Stage) ((Node)event.getSource()).getScene().getWindow();
        aba = new Scene(root);
        janela.setScene(aba);
        janela.show();
    }

    public void usuarios (ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("GerenciarUsuariosView.fxml"));
        contentArea.getChildren().setAll(root);
    }

    public void provas (ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("GerenciarProvasView.fxml"));
        contentArea.getChildren().setAll(root);
    }

    public void notas (ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(""));
        contentArea.getChildren().setAll(root);
    }

    public void relatorios (ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(""));
        contentArea.getChildren().setAll(root);
    }

    public void notificacoes (ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(""));
        contentArea.getChildren().setAll(root);
    }
}
