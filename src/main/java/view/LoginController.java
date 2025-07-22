package view;

import java.io.IOException;

import Fachada.Fachada;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import models.usuarios.Aluno;
import models.usuarios.Usuario;
import models.usuarios.professor.Professor;

public class LoginController extends FuncoesComuns {

    private Fachada fachada = new Fachada();

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
        Usuario user = fachada.getUsuarioService().findByEmail(usuario);

        if(usuario.equals("admin") && senha.equals("123")) {
            irTelaAdm(event);
        }

        if(user != null){
            if(user.getSenha().equals(senha)){
                if (user instanceof Aluno) {
                    irTelaAluno(event);
                } else if (user instanceof Professor) {
                    irTelaProfessor(event);
                }
            }
        } else {
            actionTargetText.setFill(Color.RED);
            actionTargetText.setText("Usuário ou senha inválidos.");
        }


    }
}
