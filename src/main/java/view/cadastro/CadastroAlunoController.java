package view.cadastro;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import services.UsuarioService;
import view.FuncoesComuns;

public class CadastroAlunoController extends FuncoesComuns {

    @FXML
    TextField campoNome;
    @FXML
    TextField campoCpf;
    @FXML
    TextField campoEmail;
    @FXML
    DatePicker campoData;
    @FXML
    TextField campoSenha;

    @FXML
    void cancelar(ActionEvent evento) throws IOException {
        trocarTela(evento, "/view/AdminDashboardView.fxml", "Gerenciamento de Alunos");
    }

    @FXML
    void cadastrar(ActionEvent evento) throws IOException {
        try {

            UsuarioService usuarioService = new UsuarioService();
            Integer idTurma = 1;
            Long cpf = Long.valueOf(campoCpf.getText());

            usuarioService.criarAluno(campoNome.getText(), cpf, campoData.getValue(),
                    campoEmail.getText(), campoSenha.getText(), idTurma);
                    
            System.out.println("Funcionou!");
            trocarTela(evento, "/view/AdminDashboardView.fxml", "Gerenciamento de Alunos");
            
        } catch (Exception e) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setContentText("Você não preencheu todos os campos necessários!");
            alerta.setHeaderText("Campos Vazios!");
            alerta.show();
        }
    }
}
