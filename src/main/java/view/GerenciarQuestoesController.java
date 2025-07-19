package view;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GerenciarQuestoesController {
    @FXML
    void handleVoltar(ActionEvent event) throws IOException {
        Parent dashboard = FXMLLoader.load(getClass().getResource("GerenciarProvasView.fxml"));
        Scene scene = new Scene(dashboard);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

    @FXML
    void handleAdicionarQuestao(ActionEvent event) throws IOException {
        Parent dashboard = FXMLLoader.load(getClass().getResource("cadastro/cadastroQuestao.fxml"));
        Scene scene = new Scene(dashboard);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

    @FXML
    void handleEditarQuestao(ActionEvent event) throws IOException {
        Parent dashboard = FXMLLoader.load(getClass().getResource("cadastro/cadastroQuestao.fxml"));
        Scene scene = new Scene(dashboard);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

    @FXML
    void handleCadastrarQuestoes(ActionEvent event) throws IOException {
        Parent dashboard = FXMLLoader.load(getClass().getResource("GerenciarProvasView.fxml"));
        Scene scene = new Scene(dashboard);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }
}
