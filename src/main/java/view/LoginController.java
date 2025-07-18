package view;

import java.io.IOException;

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
    void irTelaAdm(ActionEvent evento) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("AdminDashboardView.fxml"));
        janela = (Stage) ((Node)evento.getSource()).getScene().getWindow();
        aba = new Scene(root);
        janela.setScene(aba);
    }

    @FXML
    void irTelaAluno(ActionEvent evento) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("AlunoDashboardView.fxml"));
        janela = (Stage) ((Node)evento.getSource()).getScene().getWindow();
        aba = new Scene(root);
        janela.setScene(aba);
    }

    @FXML
    protected void onLoginButtonClick(ActionEvent event) throws IOException {
        String usuario = usernameField.getText();
        String senha = passwordField.getText();

        if ("admin".equals(usuario) && "123".equals(senha)) {
            irTelaAdm(event);
        }else if ("aluno".equals(usuario) && "123".equals(senha)) {
            irTelaAluno(event);
        } else {
            actionTargetText.setFill(Color.RED);
            actionTargetText.setText("Usuário ou senha inválidos.");
        }
    }
}