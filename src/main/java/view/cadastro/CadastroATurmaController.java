package view.cadastro;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import models.Turma;
import view.FuncoesComuns;

public class CadastroATurmaController extends FuncoesComuns {

    @FXML
    TextField campoID;
    
    @FXML
    void cancelar(ActionEvent evento) throws IOException {
        fecharPopup(evento);
    }

    private Turma turmaSelecionada;

    public void setTurmaSelecionada(Turma turma) {
        this.turmaSelecionada = turma;
    }

    @FXML
    void cadastrar(ActionEvent evento) throws IOException {
        try {
            int idAluno = Integer.parseInt(campoID.getText());

            if (!turmaSelecionada.getAlunos().contains(idAluno)) {
                turmaSelecionada.getAlunos().add(idAluno);
                System.out.println("Aluno " + idAluno + " adicionado à turma " + turmaSelecionada.getNome());
            } else {
                System.out.println("Aluno já está na turma.");
            }
            ((Stage)((Node)evento.getSource()).getScene().getWindow()).close();

        } catch (NumberFormatException e) {
            System.out.println("ID inválido.");
        }
    }
}
