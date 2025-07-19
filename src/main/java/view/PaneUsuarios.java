package view;

import javafx.event.ActionEvent;

public class PaneUsuarios extends FuncoesComuns {

    public void logout(ActionEvent event) {
        trocarTela(event, "login.fxml", "Login");
    }
}
