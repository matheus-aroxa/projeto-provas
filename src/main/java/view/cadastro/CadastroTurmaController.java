package view.cadastro;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import view.FuncoesComuns;

public class CadastroTurmaController extends FuncoesComuns {
    
    @FXML
    void cancelar(ActionEvent evento) throws IOException {
        trocarTela(evento, "/view/AdminDashboardView.fxml", "Menu do Administrador");
    }

    @FXML
    void cadastrar(ActionEvent evento) throws IOException {
        /*
        Aqui chama a lógica de negócio mas também vai voltar depois do cadastro
        */
        trocarTela(evento, "/view/AdminDashboardView.fxml", "Menu do Administrador");
    }
}
