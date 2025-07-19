package view;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class LoginController extends FuncoesComuns {

    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Text actionTargetText;

    @FXML
    void irTelaAdm(ActionEvent evento) throws IOException {
        trocarTela(evento, "AdminDashboardView.fxml", "Menu do Administrador");
    }

    @FXML
    void irTelaAluno(ActionEvent evento) throws IOException {
        trocarTela(evento, "AlunoDashboardView.fxml", "Menu do Aluno");
    }

    @FXML
    void irTelaProfessor(ActionEvent evento) throws IOException {
        trocarTela(evento, "ProfessorDashboardView.fxml", "Menu do Professor");
    }

    @FXML
    protected void onLoginButtonClick(ActionEvent event) throws IOException {
        String usuario = usernameField.getText();
        String senha = passwordField.getText();

        if ("admin".equals(usuario) && "123".equals(senha)) {
            irTelaAdm(event);
        } else if ("aluno".equals(usuario) && "123".equals(senha)) {
            irTelaAluno(event);
        } else if ("professor".equals(usuario) && "123".equals(senha)) {
            irTelaProfessor(event);
        } else {
            actionTargetText.setFill(Color.RED);
            actionTargetText.setText("Usuário ou senha inválidos.");
        }
    }
}
