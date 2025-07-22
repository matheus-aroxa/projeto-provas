package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

public class GerenciarRelatoriosController extends FuncoesComuns {


    @FXML
    private Button backup;

    @FXML
    private void handleFazerBackup(ActionEvent event) {

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Backup");
        alert.setHeaderText("Concluído");
        alert.setContentText("Uma cópia dos dados será enviada para o email");
        alert.showAndWait();
    }
}
