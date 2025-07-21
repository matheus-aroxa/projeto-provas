package view;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;

public abstract class FuncoesComuns {

    public void trocarTela(ActionEvent evento, String arquivoFXML, String titulo) {
        try {
            Parent page = FXMLLoader.load(getClass().getResource(arquivoFXML));
            Stage janela = (Stage) ((Node) evento.getSource()).getScene().getWindow();
            Scene aba = new Scene(page);
            janela.setTitle(titulo);
            janela.setScene(aba);
        } catch (Exception e) {
            System.err.println("\n--- OCORREU UM ERRO AO CARREGAR A TELA ---");
            e.printStackTrace();
            System.err.println("--- FIM DO ERRO ---");
        }
    }

    public void trocarAba(AnchorPane pane, String arquivoFXML) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(arquivoFXML));
            pane.getChildren().setAll(root);
        } catch (IOException e) {
            System.err.println("\n--- OCORREU UM ERRO AO CARREGAR A TELA ---");
            e.printStackTrace();
            System.err.println("--- FIM DO ERRO ---");
        }
    }

    public void abrirPopup(String fxmlPath, String titulo, Window janelaPai) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(fxmlPath));
        Stage popupStage = new Stage();
        popupStage.setTitle(titulo);
        popupStage.setScene(new Scene(root));
        popupStage.initModality(Modality.WINDOW_MODAL);
        popupStage.initOwner(janelaPai);
        popupStage.showAndWait();
    }

    public void fecharPopup(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }
}
