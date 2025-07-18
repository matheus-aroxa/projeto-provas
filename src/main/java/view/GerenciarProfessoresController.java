package view;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import DAO.ProfessorDAO;
import DAO.ProfessorDAOImpl;
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
import models.usuarios.professor.Professor;

public class GerenciarProfessoresController {
    @FXML
    private TableView<Professor> tabelaProfessores;
    @FXML
    private TableColumn<Professor, Integer> colunaId;
    @FXML
    private TableColumn<Professor, String> colunaNome;
    @FXML
    private TableColumn<Professor, Long> colunaCpf;
    @FXML
    private TableColumn<Professor, String> colunaEmail;
    @FXML
    private TableColumn<Professor, LocalDate> colunaNascimento;
    @FXML
    private TableColumn<Professor, Integer> colunaDisciplina;

    private ProfessorDAO professorDAO = new ProfessorDAOImpl();

    @FXML
    public void initialize() {
        // Configura as colunas para buscar os valores dos atributos da classe Professor
        colunaId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colunaCpf.setCellValueFactory(new PropertyValueFactory<>("cpf"));
        colunaEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colunaNascimento.setCellValueFactory(new PropertyValueFactory<>("dataDeNascimento"));
        colunaDisciplina.setCellValueFactory(new PropertyValueFactory<>("Disciplina"));

        carregarProfessors();
    }

    private void carregarProfessors() {
        tabelaProfessores.getItems().clear();
        List<Professor> Professores = professorDAO.findAll();
        ObservableList<Professor> observableProfessors = FXCollections.observableArrayList(Professores);
        tabelaProfessores.setItems(observableProfessors);
    }

    @FXML
    void handleNovoProfessor(ActionEvent event) throws IOException { //cadastroProfessor.fxml
        Parent dashboard = FXMLLoader.load(getClass().getResource("cadastro/cadastroProfessor.fxml"));
        Scene scene = new Scene(dashboard);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.setTitle("Cadastro do Professor");
        window.show();
    }

    @FXML
    void handleEditarProfessor(ActionEvent event) throws IOException {
//        Professor selecionado = tabelaProfessores.getSelectionModel().getSelectedItem();
//        if (selecionado != null) {
//            System.out.println("Ação: Editar Professor: " + selecionado.getNome());
//        } else {
//            System.out.println("Nenhum Professor selecionado para editar.");
//        }
        Parent dashboard = FXMLLoader.load(getClass().getResource("cadastro/cadastroProfessor.fxml"));
        Scene scene = new Scene(dashboard);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.setTitle("Edição do Professor");
        window.show();
    }

    @FXML
    void handleExcluirProfessor(ActionEvent event) {
        Professor selecionado = tabelaProfessores.getSelectionModel().getSelectedItem();
        if (selecionado != null) {
            System.out.println("Ação: Excluir Professor: " + selecionado.getNome());
            professorDAO.removerProfessor(selecionado.getId()); // CORREÇÃO: Usa o método da interface
            carregarProfessors();
        } else {
            System.out.println("Nenhum Professor selecionado para excluir.");
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
