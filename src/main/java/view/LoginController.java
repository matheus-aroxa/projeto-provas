package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Text actionTargetText;

    @FXML
    Stage janela;
    @FXML
    Scene aba;
    @FXML
    Parent root;

    @FXML
    void irCadastro(ActionEvent evento) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("cadastro.fxml"));
        janela = (Stage) ((Node)evento.getSource()).getScene().getWindow();
        aba = new Scene(root);
        janela.setScene(aba);
        janela.show();
    }

    @FXML
    void irTelaAdm(ActionEvent evento) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("telaAdm.fxml"));
        janela = (Stage) ((Node)evento.getSource()).getScene().getWindow();
        aba = new Scene(root);
        janela.setScene(aba);
        janela.show();
    }

    @FXML
    protected void onLoginButtonClick(ActionEvent event) throws IOException {
        String usuario = usernameField.getText();
        String senha = passwordField.getText();

        if ("admin".equals(usuario) && "123".equals(senha)) {
            irTelaAdm(event);
        } else {
            actionTargetText.setFill(Color.RED);
            actionTargetText.setText("Usuário ou senha inválidos.");
        }
    }
}