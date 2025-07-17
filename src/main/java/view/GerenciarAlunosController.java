package view;

import DAO.AlunoDAO;
import DAO.AlunoDAOImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import models.usuarios.Aluno;

import java.io.IOException;
import java.time.LocalDate; // Usei LocalDate para corresponder ao seu modelo
import java.util.List;

public class GerenciarAlunosController {

    @FXML
    private TableView<Aluno> tabelaAlunos;
    @FXML
    private TableColumn<Aluno, Integer> colunaId;
    @FXML
    private TableColumn<Aluno, String> colunaNome;
    @FXML
    private TableColumn<Aluno, Long> colunaCpf;
    @FXML
    private TableColumn<Aluno, String> colunaEmail;
    @FXML
    private TableColumn<Aluno, LocalDate> colunaNascimento;
    @FXML
    private TableColumn<Aluno, Integer> colunaTurma;

    private AlunoDAO alunoDAO = new AlunoDAOImpl();

    @FXML
    public void initialize() {
        // Configura as colunas para buscar os valores dos atributos da classe Aluno
        colunaId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colunaCpf.setCellValueFactory(new PropertyValueFactory<>("cpf"));
        colunaEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colunaNascimento.setCellValueFactory(new PropertyValueFactory<>("dataDeNascimento"));
        colunaTurma.setCellValueFactory(new PropertyValueFactory<>("idTurma")); // Corrigido para "idTurma"

        carregarAlunos();
    }

    private void carregarAlunos() {
        tabelaAlunos.getItems().clear();
        List<Aluno> alunos = alunoDAO.findAll();
        ObservableList<Aluno> observableAlunos = FXCollections.observableArrayList(alunos);
        tabelaAlunos.setItems(observableAlunos);
    }

    @FXML
    void handleNovoAluno(ActionEvent event) {
        System.out.println("Ação: Novo Aluno");
    }

    @FXML
    void handleEditarAluno(ActionEvent event) {
        Aluno selecionado = tabelaAlunos.getSelectionModel().getSelectedItem();
        if (selecionado != null) {
            System.out.println("Ação: Editar Aluno: " + selecionado.getNome());
        } else {
            System.out.println("Nenhum aluno selecionado para editar.");
        }
    }

    @FXML
    void handleExcluirAluno(ActionEvent event) {
        Aluno selecionado = tabelaAlunos.getSelectionModel().getSelectedItem();
        if (selecionado != null) {
            System.out.println("Ação: Excluir Aluno: " + selecionado.getNome());
            alunoDAO.removerAluno(selecionado.getId()); // CORREÇÃO: Usa o método da interface
            carregarAlunos();
        } else {
            System.out.println("Nenhum aluno selecionado para excluir.");
        }
    }

    @FXML
    void handleVoltar(ActionEvent event) throws IOException {
        Parent dashboard = FXMLLoader.load(getClass().getResource("AdminDashboardView.fxml"));
        Scene scene = new Scene(dashboard);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

    @FXML
    void handleSair(ActionEvent event) throws IOException {
        Parent loginPage = FXMLLoader.load(getClass().getResource("login.fxml"));
        Scene scene = new Scene(loginPage);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }
}