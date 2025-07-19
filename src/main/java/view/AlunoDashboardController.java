package view;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class AlunoDashboardController extends FuncoesComuns {
    
    @FXML
    void handleSair(ActionEvent event) throws IOException {
        trocarTela(event, "login.fxml", "Login");
    }

    @FXML
    void handleRealizarProva(ActionEvent event) throws IOException {
        trocarTela(event, "EscolhaProvaView.fxml", "Escolha de Provas");
    }
}
