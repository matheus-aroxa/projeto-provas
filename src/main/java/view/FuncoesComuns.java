package view;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public abstract  class FuncoesComuns {
    public void trocarTela(ActionEvent evento, String arquivoFXML, String titulo){
        try {
            Parent page = FXMLLoader.load(getClass().getResource(arquivoFXML));
            Stage janela = (Stage) ((Node)evento.getSource()).getScene().getWindow();
            Scene aba = new Scene(page);
            janela.setTitle(titulo);
            janela.setScene(aba);        
        }catch (Exception e) {
            System.err.println("\n--- OCORREU UM ERRO AO CARREGAR A TELA ---");
            e.printStackTrace();
            System.err.println("--- FIM DO ERRO ---");
        }
    }
    public void trocarAba(AnchorPane pane,String arquivoFXML){
        try {
            Parent root = FXMLLoader.load(getClass().getResource(arquivoFXML));            
            pane.getChildren().setAll(root);
        } catch (IOException e) {
            System.err.println("\n--- OCORREU UM ERRO AO CARREGAR A TELA ---");
            e.printStackTrace();
            System.err.println("--- FIM DO ERRO ---");
        }
    }
}
