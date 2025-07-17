package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class teste extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        // CORREÇÃO: Carregue o arquivo FXML do dashboard do admin
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AdminDashboardView.fxml"));
        Parent root = fxmlLoader.load();

        Scene scene = new Scene(root);
        stage.setTitle("Tela do Administrador");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}