package view;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import DAO.AlunoDAO;
import DAO.AlunoDAOImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import models.usuarios.Aluno;

public class GerenciarAlunosController extends FuncoesComuns {

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
    void handleNovoAluno(ActionEvent event) throws IOException { //cadastroAluno.fxml
        trocarTela(event, "cadastro/cadastroAluno.fxml", "Cadastro do Aluno");
    }

    @FXML
    void handleEditarAluno(ActionEvent event) throws IOException {
//        Aluno selecionado = tabelaAlunos.getSelectionModel().getSelectedItem();
//        if (selecionado != null) {
//            System.out.println("Ação: Editar Aluno: " + selecionado.getNome());
//        } else {
//            System.out.println("Nenhum aluno selecionado para editar.");
//        }
        trocarTela(event, "cadastro/edicaoAluno.fxml", "Edição do Aluno");
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
        trocarTela(event, "AdminDashboardView.fxml", "Menu do Administrador");
    }

    @FXML
    void handleSair(ActionEvent event) throws IOException {
        trocarTela(event, "login.fxml", "Login");
    }
}
