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
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import models.usuarios.Aluno;
import models.usuarios.Usuario;
import view.cadastro.CadastroAlunoController;

public class GerenciarAlunosController extends FuncoesComuns {

    @FXML
    private TableView<Aluno> tabelaAlunos;
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
//    @FXML
//    private TableColumn<Aluno, Integer> colunaTurma;

    private AlunoDAO alunoDAO = new AlunoDAOImpl();

    @FXML
    public void initialize() {
        // Configura as colunas para buscar os valores dos atributos da classe Aluno
        colunaId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colunaCpf.setCellValueFactory(new PropertyValueFactory<>("cpf"));
        colunaEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colunaNascimento.setCellValueFactory(new PropertyValueFactory<>("dataDeNascimento"));
        // colunaTurma.setCellValueFactory(new PropertyValueFactory<>("idTurma")); // Corrigido para "idTurma"

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
        Aluno selecionado = tabelaAlunos.getSelectionModel().getSelectedItem();

        if (selecionado != null) {
            System.out.println("Ação: Editar Aluno: " + selecionado.getNome());

            FXMLLoader loader = new FXMLLoader(getClass().getResource("cadastro/cadastroAluno.fxml"));
            Parent page = loader.load();
            CadastroAlunoController controlador = loader.getController();
            Stage janela = ((Stage) ((Node) event.getSource()).getScene().getWindow());
            
            controlador.setAluno(selecionado);
            janela.setScene(new Scene(page));
            janela.setTitle("Edição do Aluno");
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
}
