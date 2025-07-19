package view;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class GerenciarProvasController extends FuncoesComuns{

    @FXML
    void handleNovaProva(ActionEvent event) throws IOException {
        trocarTela(event, "cadastro/cadastroProva.fxml", "Cadastro da Prova");
    }

    @FXML
    void handleEditarProva(ActionEvent event) throws IOException {
        trocarTela(event, "cadastro/cadastroProva.fxml", "Edição da Prova");
    }

    @FXML
    void handleEnviarProva(ActionEvent event) throws IOException {
        trocarTela(event, "EnvioProvaView.fxml", "Enviar Prova");
    }

    @FXML
    void handleExcluirProva(ActionEvent event) throws IOException {
        //trocarTela(event, "cadastro/cadastroProva.fxml", "Edição da Prova");
    }
}
