package view.cadastro;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CadastroTurmaController {
    
    @FXML
    void cancelar(ActionEvent evento) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/AdminDashboardView.fxml"));
        Stage janela = (Stage) ((Node)evento.getSource()).getScene().getWindow();
        Scene aba = new Scene(root);
        janela.setScene(aba);
    }

    @FXML
    void cadastrar(ActionEvent evento) throws IOException {
        /*
        Aqui chama a lógica de negócio mas também vai voltar depois do cadastro
        */
        Parent root = FXMLLoader.load(getClass().getResource("/view/AdminDashboardView.fxml"));
        Stage janela = (Stage) ((Node)evento.getSource()).getScene().getWindow();
        Scene aba = new Scene(root);
        janela.setScene(aba);
    }
}
