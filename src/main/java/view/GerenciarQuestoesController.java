package view;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import models.provas.Prova;

public class GerenciarQuestoesController extends FuncoesComuns {

    private Prova prova;

    public void setProva(Prova prova){
        this.prova = prova;
    }

    @FXML
    void handleVoltar(ActionEvent event) throws IOException {
        trocarTela(event, "cadastro/cadastroProva.fxml", "Gerenciar Provas");
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
        trocarTela(event, "/view/ProfessorDashboardView.fxml", "Gerenciar Provas");
    }
}
