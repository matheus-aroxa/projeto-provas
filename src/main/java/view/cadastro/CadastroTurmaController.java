package view.cadastro;

import DAO.TurmaDAO;
import DAO.TurmaDAOlmpl;
import Exceptions.RequiredArgumentIsNullException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import models.Turma;
import  view.FuncoesComuns;

public class CadastroTurmaController extends FuncoesComuns {

    @FXML
    TextField campoNome;
    @FXML
    TextField campoProfessor;
    @FXML
    TextField campoId;

    private TurmaDAO turmaDAO = new TurmaDAOlmpl();

    @FXML
    void handleCadastrar(ActionEvent event){
        try {
            String nome = campoNome.getText();
            int idProfessor = Integer.parseInt(campoProfessor.getText());
            int idTurma = Integer.parseInt(campoId.getText());

            if (nome == null || campoId.getText() == null || campoProfessor.getText() == null) {
                throw new RequiredArgumentIsNullException("Campos Obrigatórios!");
            }

            Turma turma = new Turma(idTurma, nome, idProfessor);
            turmaDAO.adicionar(turma);

            fecharPopup(event);
        } catch (RequiredArgumentIsNullException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro de Entrada");
            alert.setHeaderText("Campo inválido");
            alert.setContentText("Por favor, insira valores válidos nos campos!");
            alert.showAndWait();
        }
    }

    @FXML
    void handleCancelar(ActionEvent event){
        fecharPopup(event);
    }
}
