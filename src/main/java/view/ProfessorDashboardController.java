package view;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class ProfessorDashboardController extends FuncoesComuns{
    
    @FXML
    void handleSair(ActionEvent event) throws IOException {
        trocarTela(event, "login.fxml", "Login");
    }

    @FXML
    void handelGerenciarProvas(ActionEvent event) throws IOException{
        trocarTela(event, "GerenciarProvasView.fxml", "Gerenciamento de Provas");
    }
}
