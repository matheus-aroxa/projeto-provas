package view;

import java.io.IOException;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import models.Turma;
import services.TurmaService; // Importe seu serviço

public class EnvioProvaController extends FuncoesComuns {


    @FXML
    private TableView<Turma> tabelaTurmas;

    @FXML
    private TableColumn<Turma, Integer> colunaId;

    @FXML
    private TableColumn<Turma, String> colunaNome;

    private TurmaService turmaService = new TurmaService();

    @FXML
    public void initialize() {
        colunaId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        carregarTurmas();
    }

    private void carregarTurmas() {
        List<Turma> listaDeTurmas = turmaService.listarTodasAsTurmas();
        ObservableList<Turma> turmasObservaveis = FXCollections.observableArrayList(listaDeTurmas);

        // Define os itens na tabela
        tabelaTurmas.setItems(turmasObservaveis);
    }

    @FXML
    void handleEnviarProva(ActionEvent event) throws IOException {
        Turma turmaSelecionada = tabelaTurmas.getSelectionModel().getSelectedItem();
        if (turmaSelecionada != null) {
            System.out.println("Enviando prova para a turma: " + turmaSelecionada.getNome());
            //falta mandar
        } else {
            System.out.println("Nenhuma turma selecionada.");
        }
    }

    @FXML
    void handleVoltar(ActionEvent event) throws IOException {
        trocarTela(event, "ProfessorDashboardView.fxml", "Gerenciamento de Provas");
    }
}