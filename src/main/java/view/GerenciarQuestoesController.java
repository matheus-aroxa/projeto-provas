package view;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class GerenciarQuestoesController extends FuncoesComuns {

    @FXML
    void handleVoltar(ActionEvent event) throws IOException {
        trocarTela(event, "GerenciarProvasView.fxml", "Gerenciar Provas");
    }

    @FXML
    void handleAdicionarQuestao(ActionEvent event) throws IOException {
        trocarTela(event, "cadastro/cadastroQuestao.fxml", "Cadastro de Questões");
    }

    @FXML
    void handleEditarQuestao(ActionEvent event) throws IOException {
        trocarTela(event, "cadastro/cadastroQuestao.fxml", "Edição de Questões");
    }

    @FXML
    void handleCadastrarQuestoes(ActionEvent event) throws IOException {
        trocarTela(event, "GerenciarProvasView.fxml", "Gerenciar Provas");
    }
}
