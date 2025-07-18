package view;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GerenciamentoDeRelatoriosController {

    @FXML
    void handleVoltar(ActionEvent event) throws IOException {
        Parent dashboard = FXMLLoader.load(getClass().getResource("AdminDashboardView.fxml"));
        Scene scene = new Scene(dashboard);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

    @FXML
    void handleSair(ActionEvent event) throws IOException {
        Parent loginPage = FXMLLoader.load(getClass().getResource("login.fxml"));
        Scene scene = new Scene(loginPage);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

}
