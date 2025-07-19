package view;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class AdminDashboardController extends FuncoesComuns {

    @FXML
    void handleGerenciarAlunos(ActionEvent event) throws IOException {
        System.out.println("DEBUG: Tentando abrir a tela de gerenciamento de alunos...");
        trocarTela(event, "GerenciarAlunosView.fxml", "Gerenciamento de Alunos");
    }

    @FXML
    void handleGerenciarProfessores(ActionEvent event) throws IOException {
        trocarTela(event, "GerenciarProfessoresView.fxml", "Gerenciamento de Professores");
    }

    @FXML
    void handleNovaTurma(ActionEvent event) throws IOException {
        trocarTela(event, "cadastro/cadastroTurma.fxml", "Cadastro de Turma");
    }

    @FXML
    void handleGerenciarRelatorios(ActionEvent event) throws IOException {
        trocarTela(event, "GerenciarRelatoriosView.fxml", "Gerenciamento de Relatórios");
    }

    @FXML
    void handleBackup(ActionEvent event) {
        System.out.println("Ação: Realizar Backup");
    }

    @FXML
    void handleSair(ActionEvent event) throws IOException {
        trocarTela(event, "login.fxml", "Login");
    }
}
