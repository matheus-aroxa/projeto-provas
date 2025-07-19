package view;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class EscolhaProvaController extends FuncoesComuns {

    @FXML
    void handleVoltar(ActionEvent event) throws IOException {
        trocarTela(event, "AlunoDashboardView.fxml", "Menu do Aluno");
    }

    @FXML
    void handleSair(ActionEvent event) throws IOException {
        trocarTela(event, "login.fxml", "Login");
    }

    @FXML
    void handleRealizarProva(ActionEvent event) throws IOException {
        trocarTela(event, "AvaliacaoProvaView.fxml", "Avaliação");
    }

}
