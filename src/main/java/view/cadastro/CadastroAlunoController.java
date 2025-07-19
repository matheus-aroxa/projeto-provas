package view.cadastro;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import view.FuncoesComuns;

public class CadastroAlunoController extends FuncoesComuns {

    @FXML
    void cancelar(ActionEvent evento) throws IOException {
        trocarTela(evento, "/view/AdminDashboardView.fxml","Gerenciamento de Alunos");
    }

    @FXML
    void cadastrar(ActionEvent evento) throws IOException {
        trocarTela(evento, "/view/AdminDashboardView.fxml","Gerenciamento de Alunos");
    }
}