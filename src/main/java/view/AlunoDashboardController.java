package view;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AlunoDashboardController {
    
    @FXML
    void handleSair(ActionEvent event) throws IOException {
        System.out.println("Ação: Sair (logout)");
        Parent loginPage = FXMLLoader.load(getClass().getResource("login.fxml"));
        Scene loginScene = new Scene(loginPage);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(loginScene);
        window.show();
    }
}
