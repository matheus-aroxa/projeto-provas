package view.cadastro;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import view.FuncoesComuns;

public class CadastroProfessorController extends FuncoesComuns {

    @FXML
    void cancelar(ActionEvent evento) throws IOException {
        trocarTela(evento, "/view/GerenciarProfessoresView.fxml", "Gerenciamento de Professores");
    }

    @FXML
    void cadastrar(ActionEvent evento) throws IOException {
        trocarTela(evento, "/view/GerenciarProfessoresView.fxml", "Gerenciamento de Professores");
    }

}
