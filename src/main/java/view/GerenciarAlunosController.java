package view;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import DAO.AlunoDAOImpl;
import DAO.ObjectDAO;
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

    private ObjectDAO alunoDAO = new AlunoDAOImpl();

    @FXML
    public void initialize() {

        colunaId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colunaCpf.setCellValueFactory(new PropertyValueFactory<>("cpf"));
        colunaEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colunaNascimento.setCellValueFactory(new PropertyValueFactory<>("dataDeNascimento"));


        carregarAlunos();
    }

    private void carregarAlunos() {
        tabelaAlunos.getItems().clear();
        List<Aluno> alunos = alunoDAO.findAll();
        ObservableList<Aluno> observableAlunos = FXCollections.observableArrayList(alunos);
        tabelaAlunos.setItems(observableAlunos);
    }

    @FXML
    void handleNovoAluno(ActionEvent event) throws IOException {
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
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmação");
            alert.setHeaderText("Tem certeza que deseja excluir este aluno?");
            alert.setContentText("Aluno: " + selecionado.getNome() + "\nEsta ação não pode ser desfeita.");

            Optional<ButtonType> resultado = alert.showAndWait();

            if (resultado.isPresent() && resultado.get() == ButtonType.OK) {
                alunoDAO.remover(selecionado.getId());
                carregarAlunos();
                System.out.println("Prova excluída com sucesso.");
            }
        } else {
            System.out.println("Nenhum aluno selecionado para excluir.");
        }
    }
}
