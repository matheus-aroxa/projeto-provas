package view;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class AvaliacaoProvaController extends FuncoesComuns {

    @FXML
    void anterior(ActionEvent evento) throws IOException {
        trocarTela(evento, "EscolhaProvaView.fxml", "Escolha de Provas");
    }

    @FXML
    void proximo(ActionEvent evento) throws IOException {
        /*
        Aqui chama a lógica de negócio mas também vai voltar depois do cadastro
         */
        trocarTela(evento, "EscolhaProvaView.fxml", "Escolha de Provas");
    }
}
