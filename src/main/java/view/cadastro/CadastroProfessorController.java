package view.cadastro;

import java.io.IOException;

import Fachada.Fachada;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import models.usuarios.professor.Professor;
import services.UsuarioService;
import view.FuncoesComuns;

public class CadastroProfessorController extends FuncoesComuns {

    private Professor professor;
    private Fachada fachada;

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
    TextField campoDisciplina;

    public void setProfessor(Professor professor) {
        this.professor = professor;
        preencherCampos();
    }

    public void preencherCampos() {
        if (professor != null) {
            campoNome.setText(professor.getNome());
            campoCpf.setText(String.valueOf(professor.getCpf()));
            campoEmail.setText(professor.getEmail());
            campoData.setValue(professor.getDataDeNascimento());
            campoSenha.setText(professor.getSenha());
            campoDisciplina.setText(professor.getDisciplina());
        }
    }

    @FXML
    void cancelar(ActionEvent evento) throws IOException {
        trocarTela(evento, "/view/AdminDashboardView.fxml", "Gerenciamento de Professores");
    }

    @FXML
    void cadastrar(ActionEvent evento) throws IOException {
        try {
            Long cpf = Long.valueOf(campoCpf.getText());
            Integer idTurma = 1;

            if (professor == null) {
                Professor novoProfessor = new Professor(0, campoNome.getText(), cpf, campoData.getValue(),
                        campoEmail.getText(), campoSenha.getText(), idTurma, campoDisciplina.getText());

                fachada.getUsuarioService().criarProfessor(novoProfessor);
            } else {
                
                professor.setNome(campoNome.getText());
                professor.setEmail(campoEmail.getText());
                professor.setCpf(cpf);
                professor.setDataDeNascimento(campoData.getValue());
                professor.setSenha(campoSenha.getText());
                professor.setDisciplina(campoDisciplina.getText());
                fachada.getUsuarioService().editarProfessor(professor);
            }
            
            trocarTela(evento, "/view/AdminDashboardView.fxml", "Gerenciamento de Professores");
        } catch (Exception e) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setContentText("Você não preencheu todos os campos necessários!");
            alerta.setHeaderText("Campos Vazios!");
            alerta.show();
        }

    }

}
