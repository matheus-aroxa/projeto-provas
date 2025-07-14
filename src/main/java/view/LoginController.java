package view;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class LoginController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Text actionTargetText;

    @FXML
    protected void onLoginButtonClick() {
        String usuario = usernameField.getText();
        String senha = passwordField.getText();

        if ("admin".equals(usuario) && "123".equals(senha)) {
            actionTargetText.setFill(Color.GREEN);
            actionTargetText.setText("Login bem-sucedido!");
        } else {
            actionTargetText.setFill(Color.RED);
            actionTargetText.setText("Usuário ou senha inválidos.");
        }
    }
}