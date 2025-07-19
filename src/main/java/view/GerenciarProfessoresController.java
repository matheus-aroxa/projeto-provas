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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import models.usuarios.professor.Professor;

public class GerenciarProfessoresController extends FuncoesComuns {
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
    void handleNovoProfessor(ActionEvent event) throws IOException {
        trocarTela(event, "cadastro/cadastroProfessor.fxml", "Cadastro do Professor");
    }

    @FXML
    void handleEditarProfessor(ActionEvent event) throws IOException {
//        Professor selecionado = tabelaProfessores.getSelectionModel().getSelectedItem();
//        if (selecionado != null) {
//            System.out.println("Ação: Editar Professor: " + selecionado.getNome());
//        } else {
//            System.out.println("Nenhum Professor selecionado para editar.");
//        }
        trocarTela(event, "cadastro/cadastroProfessor.fxml", "Edição do Professor");
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
        trocarTela(event, "AdminDashboardView.fxml", "Menu do Administrador");
    }

    @FXML
    void handleSair(ActionEvent event) throws IOException {
        trocarTela(event, "login.fxml", "Login");
    }
}
