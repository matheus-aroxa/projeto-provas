package view;

import java.io.IOException;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import models.Turma;
import models.provas.Prova;
import services.TurmaService; // Importe seu serviço

public class EnvioProvaController extends FuncoesComuns {


    @FXML
    private TableView<Turma> tabelaTurmas;

    @FXML
    private TableColumn<Turma, Integer> colunaId;

    @FXML
    private TableColumn<Turma, String> colunaNome;

    private TurmaService turmaService = new TurmaService();
    private Prova prova;

    @FXML
    public void initialize() {
        colunaId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        carregarTurmas();
    }

    private void carregarTurmas() {
        List<Turma> listaDeTurmas = turmaService.listarTodasAsTurmas();
        ObservableList<Turma> turmasObservaveis = FXCollections.observableArrayList(listaDeTurmas);

        tabelaTurmas.setItems(turmasObservaveis);
    }

    public void setProva(Prova prova){
        this.prova = prova;
    }

    @FXML
void handleEnviarProva(ActionEvent event) throws IOException {
    Turma turmaSelecionada = tabelaTurmas.getSelectionModel().getSelectedItem();
    
    // Verifique se tanto a turma quanto a prova existem
    if (turmaSelecionada != null && this.prova != null) {
        
        // CORREÇÃO: Chame o método para adicionar a prova à lista da turma
        turmaSelecionada.adicionarProva(this.prova);

        // Feedback para o usuário
        System.out.println("Prova '" + this.prova.getTitulo() + "' enviada para a turma: " + turmaSelecionada.getNome());
        
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Sucesso");
        alert.setHeaderText("Prova enviada com sucesso!");
        alert.setContentText("A prova '" + this.prova.getTitulo() + "' foi associada à turma '" + turmaSelecionada.getNome() + "'.");
        alert.showAndWait();
        
        
        trocarTela(event, "ProfessorDashboardView.fxml", "Gerenciamento de Provas");

    } else if (turmaSelecionada == null) {
        System.out.println("Nenhuma turma selecionada.");
        // Alerta para o usuário
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Aviso");
        alert.setHeaderText("Nenhuma turma selecionada");
        alert.setContentText("Por favor, selecione uma turma para enviar a prova.");
        alert.showAndWait();
    } else {
        // Este caso não deveria acontecer se a lógica estiver correta, mas é uma boa proteção
        System.out.println("Erro: A prova a ser enviada não foi definida.");
    }
}

    @FXML
    void handleVoltar(ActionEvent event) throws IOException {
        trocarTela(event, "ProfessorDashboardView.fxml", "Gerenciamento de Provas");
    }
}