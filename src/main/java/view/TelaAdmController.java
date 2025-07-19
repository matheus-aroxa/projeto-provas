package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class TelaAdmController  {
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
        Parent root = FXMLLoader.load(getClass().getResource("telaAdm.fxml"));
        janela = (Stage) ((Node)event.getSource()).getScene().getWindow();
        aba = new Scene(root);
        janela.setScene(aba);
        janela.show();
    }

    public void usuarios (ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("paneUsuarioAdm.fxml"));
        contentArea.getChildren().setAll(root);
    }

    public void alunos (ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("paneAlunoAdm.fxml"));
        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(root);
    }

    public void professores (ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("paneProfeAdm.fxml"));
        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(root);
    }

    public void turmas (ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("paneTurmaAdm.fxml"));
        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(root);
    }

    public void settings (ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("paneSettingsAdm.fxml"));
        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(root);
    }
}
