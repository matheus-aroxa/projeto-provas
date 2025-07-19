package view;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class EnvioProvaController extends FuncoesComuns {

    @FXML
    void handleEnviarProva(ActionEvent event) throws IOException {
        trocarTela(event, "GerenciarProvasView.fxml", "Gerenciamento de Provas");
    }

    @FXML
    void handleVoltar(ActionEvent event) throws IOException {
        trocarTela(event, "GerenciarProvasView.fxml", "Gerenciamento de Provas");
    }
}
