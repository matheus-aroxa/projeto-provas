package view;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class CadastroController {

    @FXML
    Stage janela;
    @FXML
    Scene aba;
    @FXML
    Parent root;

    @FXML
    void irLogin(ActionEvent evento) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        janela = (Stage) ((Node)evento.getSource()).getScene().getWindow();
        aba = new Scene(root);
        janela.setScene(aba);
        janela.show();
    }

}
