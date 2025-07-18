package view;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AdminDashboardController {

    // ... (seus outros @FXML e métodos permanecem os mesmos)
    @FXML
    void handleGerenciarAlunos(ActionEvent event) {
        System.out.println("DEBUG: Tentando abrir a tela de gerenciamento de alunos...");
        try {
            // Carrega a nova tela
            Parent gerenciarAlunosPage = FXMLLoader.load(getClass().getResource("GerenciarAlunosView.fxml"));
            Scene scene = new Scene(gerenciarAlunosPage);

            // Pega a janela atual
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

            // Define a nova tela na janela
            window.setScene(scene);
            window.show();

            System.out.println("DEBUG: Tela de alunos carregada com sucesso!");

        } catch (Exception e) {
            // Se qualquer erro acontecer ao carregar a tela, ele será impresso aqui
            System.err.println("\n--- OCORREU UM ERRO AO CARREGAR A TELA ---");
            e.printStackTrace();
            System.err.println("--- FIM DO ERRO ---");
        }
    }

    @FXML
    void handleGerenciarProfessores(ActionEvent event) {
        try {
            Parent gerenciarProfessoresPage = FXMLLoader.load(getClass().getResource("GerenciarProfessoresView.fxml"));
            Scene gerenciarProfessoresScene = new Scene(gerenciarProfessoresPage);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(gerenciarProfessoresScene);
            System.out.println("Ação: Gerenciar Professores");
        } catch (Exception e) {
            System.err.println("\n--- OCORREU UM ERRO AO CARREGAR A TELA ---");
            e.printStackTrace();
            System.err.println("--- FIM DO ERRO ---");
        }
    }

    @FXML
    void handleGerenciarTurmas(ActionEvent event) {
        System.out.println("Ação: Gerenciar Turmas");
    }

    @FXML
    void handleGerenciarRelatorios(ActionEvent event) {
        System.out.println("Ação: Gerenciar Relatórios");
    }

    @FXML
    void handleBackup(ActionEvent event) {
        System.out.println("Ação: Realizar Backup");
    }

    /**
     * CORREÇÃO: Este método agora usa a forma padrão do JavaFX para trocar de
     * tela.
     */
    @FXML
    void handleSair(ActionEvent event) throws IOException {
        System.out.println("Ação: Sair (logout)");

        // Carrega o FXML da tela de login
        // Assumindo que você quer voltar para a tela "login.fxml"
        Parent loginPage = FXMLLoader.load(getClass().getResource("login.fxml"));
        Scene loginScene = new Scene(loginPage);

        // Obtém a janela (Stage) atual a partir do evento do botão
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        // Define a nova cena na janela
        window.setScene(loginScene);
        window.show();
    }
}
