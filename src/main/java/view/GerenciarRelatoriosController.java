package view;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class GerenciarRelatoriosController extends FuncoesComuns {

    @FXML
    void handleVoltar(ActionEvent event) throws IOException {
        trocarTela(event, "AdminDashboardView.fxml", "Menu do Administrador");
    }

    @FXML
    void handleSair(ActionEvent event) throws IOException {
        trocarTela(event, "login.fxml", "Login");
    }

}
