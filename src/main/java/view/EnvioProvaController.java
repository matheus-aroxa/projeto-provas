package view;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;

public class EnvioProvaController extends FuncoesComuns {

    @FXML
    TableView tablea;

    @FXML
    void handleEnviarProva(ActionEvent event) throws IOException {
        trocarTela(event, "ProfessorDashboardView.fxml", "Gerenciamento de Provas");
    }

    @FXML
    void handleVoltar(ActionEvent event) throws IOException {
        trocarTela(event, "ProfessorDashboardView.fxml", "Gerenciamento de Provas");
    }

}
