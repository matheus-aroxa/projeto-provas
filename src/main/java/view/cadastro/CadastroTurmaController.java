package view.cadastro;

import DAO.ProfessorDAO;
import DAO.ProfessorDAOImpl;
import DAO.TurmaDAO;
import DAO.TurmaDAOlmpl;
import Exceptions.RequiredArgumentIsNullException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import models.Turma;
import view.FuncoesComuns;
import  javafx.scene.control.TextField;

import java.awt.*;

public class CadastroTurmaController extends FuncoesComuns {

    @FXML
    TextField campoNome;
    @FXML
    Text messageText;


    private TurmaDAO turmaDAO = new TurmaDAOlmpl();

    @FXML
    void handleCadastrar(ActionEvent event){
            String nome = campoNome.getText();

            if (nome == null) {
                messageText.setFill(Color.RED);
                messageText.setText("Campos Inválidos!");
            }
            turmaDAO.add(nome);
            fecharPopup(event);
    }

    @FXML
    void handleCancelar(ActionEvent event){
        fecharPopup(event);
    }
}
