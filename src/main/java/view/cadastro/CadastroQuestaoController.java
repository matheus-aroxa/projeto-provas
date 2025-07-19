package view.cadastro;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import view.FuncoesComuns;

public class CadastroQuestaoController extends FuncoesComuns {
    
    @FXML
    void voltar(ActionEvent evento) throws IOException {
        trocarTela(evento, "/view/ProfessorDashboardView.fxml", "Gerenciamento de Questões");
    }

    @FXML
    void cadastrar(ActionEvent evento) throws IOException {
        /*
        Aqui chama a lógica de negócio mas também vai voltar depois do cadastro
         */
        trocarTela(evento, "/view/GerenciarQuestoesView.fxml", "Gerenciamento de Questões");
    }
}
