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

    public void users (ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("telaAdm.fxml"));
        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(root);
    }

    public void students (ActionEvent event) throws IOException {
      //  Parent root = FXMLLoader.load(getClass().getResource("telaAdm.fxml"));
        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(root);
    }

    public void teachers (ActionEvent event) throws IOException {
       // Parent root = FXMLLoader.load(getClass().getResource("telaAdm.fxml"));
        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(root);
    }

    public void classes (ActionEvent event) throws IOException {
       // Parent root = FXMLLoader.load(getClass().getResource("telaAdm.fxml"));
        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(root);
    }

    public void settings (ActionEvent event) throws IOException {
      //  Parent root = FXMLLoader.load(getClass().getResource("telaAdm.fxml"));
        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(root);
    }
}
