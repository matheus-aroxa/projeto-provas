package view.cadastro;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import view.FuncoesComuns;

public class CadastroController extends FuncoesComuns implements Initializable {


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
        trocarTela(evento,"login.fxml", "Login");
    }

    @FXML
    void cadastro(ActionEvent evento){
        if(escolhaUsuario.getValue() != null){

        }else{
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setContentText("Por favor selecione uma opção válida!");
            alerta.setHeaderText("Opção de tipo de usuário vazia");
            alerta.show();
        }
    }

}
