package view;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import DAO.ObjectDAO;
import DAO.ProfessorDAOImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import models.usuarios.Usuario;
import models.usuarios.professor.Professor;
import view.cadastro.CadastroProfessorController;

public class GerenciarProfessoresController extends FuncoesComuns {

    @FXML
    private TableView<Professor> tabelaProfessores;
    @FXML
    private TableColumn<Usuario, Integer> colunaId;
    @FXML
    private TableColumn<Usuario, String> colunaNome;
    @FXML
    private TableColumn<Usuario, Long> colunaCpf;
    @FXML
    private TableColumn<Usuario, String> colunaEmail;
    @FXML
    private TableColumn<Usuario, LocalDate> colunaNascimento;
    @FXML
    private TableColumn<Professor, String> colunaDisciplina;

    private ObjectDAO professorDAO = new ProfessorDAOImpl();

    @FXML
    public void initialize() {

        colunaId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colunaCpf.setCellValueFactory(new PropertyValueFactory<>("cpf"));
        colunaEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colunaNascimento.setCellValueFactory(new PropertyValueFactory<>("dataDeNascimento"));
        colunaDisciplina.setCellValueFactory(new PropertyValueFactory<>("disciplina"));

        carregarProfessores();
    }

    private void carregarProfessores() {
        tabelaProfessores.getItems().clear();
        List<Professor> professores = professorDAO.findAll();
        ObservableList<Professor> observableProfessores = FXCollections.observableArrayList(professores);
        tabelaProfessores.setItems(observableProfessores);
    }

    @FXML
    void handleNovoProfessor(ActionEvent event) throws IOException {
        trocarTela(event, "cadastro/cadastroProfessor.fxml", "Cadastro do Professor");
    }

    @FXML
    void handleEditarProfessor(ActionEvent event) throws IOException {
       Professor selecionado = tabelaProfessores.getSelectionModel().getSelectedItem();
       
       if (selecionado != null) {
            System.out.println("Ação: Editar Professor: " + selecionado.getNome());

            FXMLLoader loader = new FXMLLoader(getClass().getResource("cadastro/cadastroProfessor.fxml"));
            Parent page = loader.load();
            CadastroProfessorController controlador = loader.getController();
            Stage janela = ((Stage) ((Node)event.getSource()).getScene().getWindow());

            controlador.setProfessor(selecionado);
            janela.setScene(new Scene(page));
            janela.setTitle("Edição do professor");
       } else {
           System.out.println("Nenhum Professor selecionado para editar.");
       }
    }

    @FXML
    void handleExcluirProfessor(ActionEvent event) {
        Professor selecionado = tabelaProfessores.getSelectionModel().getSelectedItem();
        if (selecionado != null) {
            System.out.println("Ação: Excluir Professor: " + selecionado.getNome());

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmação");
            alert.setHeaderText("Tem certeza que deseja excluir este professor?");
            alert.setContentText("Professor: " + selecionado.getNome() + "\nEsta ação não pode ser desfeita.");

            Optional<ButtonType> resultado = alert.showAndWait();

            if (resultado.isPresent() && resultado.get() == ButtonType.OK) {
                professorDAO.remover(selecionado.getId());
                carregarProfessores();
                System.out.println("Prova excluída com sucesso.");
            }
        } else {
            System.out.println("Nenhum Professor selecionado para excluir.");
        }
    }
}
