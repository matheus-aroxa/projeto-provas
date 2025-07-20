package view.cadastro;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import models.usuarios.Aluno;
import services.UsuarioService;
import view.FuncoesComuns;

public class CadastroAlunoController extends FuncoesComuns {

    private Aluno aluno;

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

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
        preencherCampos();
    }

    private void preencherCampos() {
        if (aluno != null) {
            campoNome.setText(aluno.getNome());
            campoCpf.setText(String.valueOf(aluno.getCpf()));
            campoEmail.setText(aluno.getEmail());
            campoData.setValue(aluno.getDataDeNascimento());
            campoSenha.setText(aluno.getSenha());
        }
    }

    @FXML
    void cancelar(ActionEvent evento) throws IOException {
        trocarTela(evento, "/view/AdminDashboardView.fxml", "Gerenciamento de Alunos");
    }

    @FXML
    void cadastrar(ActionEvent evento) throws IOException {
        try {
            UsuarioService usuarioService = new UsuarioService();
            Long cpf = Long.valueOf(campoCpf.getText());
            Integer idTurma = 1; // Você pode querer tornar isso configurável

            if (aluno == null) {
                Aluno novoAluno = new Aluno(0, campoNome.getText(), cpf, campoData.getValue(), campoEmail.getText(), campoSenha.getText(), idTurma) ;    
                usuarioService.criarAluno(novoAluno);
            } else {
                
                aluno.setNome(campoNome.getText());
                aluno.setEmail(campoEmail.getText());
                aluno.setDataDeNascimento(campoData.getValue());
                aluno.setSenha(campoSenha.getText());

                usuarioService.editarAluno(aluno);
            }

            trocarTela(evento, "/view/AdminDashboardView.fxml", "Gerenciamento de Alunos");
        } catch (Exception e) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setContentText("Você não preencheu todos os campos necessários!");
            alerta.setHeaderText("Campos Vazios!");
            alerta.show();
        }
    }
}
