package view.cadastro;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import view.FuncoesComuns;

public class CadastroProvaController extends FuncoesComuns {

    @FXML
    void cancelar(ActionEvent evento) throws IOException {
        trocarTela(evento, "/view/ProfessorDashboardView.fxml", "Gerenciamento de Provas");
    }

    @FXML
    void proximo(ActionEvent evento) throws IOException {
        trocarTela(evento, "/view/GerenciarQuestoesView.fxml", "Gerenciamento de Questões");
    }

}
