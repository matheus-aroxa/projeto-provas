package view.cadastro;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CadastroController implements Initializable {

    @FXML
    private Stage janela;
    @FXML
    private Scene aba;
    @FXML
    private Parent root;
    @FXML
    private ChoiceBox<String> escolhaUsuario;
    private String[] tipos = {"Aluno","Professor"};

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        escolhaUsuario.getItems().addAll(tipos);
    }

    void getTipos(ActionEvent evento){
        String atual = escolhaUsuario.getValue();
    }

    @FXML
    void irLogin(ActionEvent evento) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        janela = (Stage) ((Node)evento.getSource()).getScene().getWindow();
        aba = new Scene(root);
        janela.setScene(aba);
        janela.show();
    }

    @FXML
    void cadastro(ActionEvent evento){
        if(escolhaUsuario.getValue() != null){
            //implementação futura
        }else{
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setContentText("Por favor selecione uma opção válida!");
            alerta.setHeaderText("Opção de tipo de usuário vazia");
            alerta.show();
        }
    }

}
