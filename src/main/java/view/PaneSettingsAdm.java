package view;

import Fachada.Fachada;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import models.usuarios.Usuario;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PaneSettingsAdm {

    Fachada fachada = new Fachada();

    @FXML
    private Button backup;

    @FXML
    private void handleFazerBackup(ActionEvent event) {

        String usuarios = fachada.getUsuarioService().findAll().toString();
        String provas = fachada.getProvaService().findAll().toString();
        String questoes = fachada.getQuestaoService().findAll().toString();

        String conteudo = new String("Usuarios: " + usuarios + "\nProvas: " + provas + "\nQuestoes: " + questoes);
        String nome = "backup.txt";

        Path caminho = Paths.get(nome);

        try {
            Files.writeString(caminho, conteudo);

        } catch (IOException e) {
            System.err.println("Erro ao salvar o arquivo: " + e.getMessage());
            e.printStackTrace();
        }

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Backup");
        alert.setHeaderText("O arquivo foi salvo com sucesso");
        alert.setContentText("Localização: " + caminho.toAbsolutePath());
        alert.showAndWait();
    }
}
