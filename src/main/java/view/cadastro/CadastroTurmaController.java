package view.cadastro;

import DAO.TurmaDAOlmpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import view.FuncoesComuns;

public class CadastroTurmaController extends FuncoesComuns {

    @FXML
    TextField campoNome;
    @FXML
    Text messageText;


    private TurmaDAOlmpl turmaDAO = new TurmaDAOlmpl();

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
