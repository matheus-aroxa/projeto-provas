package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

public class GerenciarUsuariosController extends FuncoesComuns{

    @FXML
    void handleSair(ActionEvent event) throws IOException {
        trocarTela(event, "login.fxml", "Login");
    }
}
