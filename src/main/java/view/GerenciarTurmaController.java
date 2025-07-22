package view;

import java.io.IOException;
import java.util.List;

import DAO.ObjectDAO;
import DAO.ProfessorDAOImpl;
import DAO.TurmaDAOlmpl;
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
import models.Turma;
import models.usuarios.professor.Professor;
import view.cadastro.CadastroATurmaController;

public class GerenciarTurmaController extends FuncoesComuns{

    @FXML
    private TableView<Turma> tabelaTurmas;
    @FXML
    private TableColumn<Turma, Integer> colunaId;
    @FXML
    private TableColumn<Turma, String> colunaNome;
    @FXML
    private TableColumn<Turma, Integer> colunaAlunos;

    private TurmaDAOlmpl turmaDAO = new TurmaDAOlmpl();
    private ObjectDAO<Professor> professorDAO = new ProfessorDAOImpl();

    public void initialize(){
        colunaId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
//        colunaProfessor.setCellValueFactory(cellData -> {
//            Turma turma = cellData.getValue();
//            String nomeProfessor = professorDAO.getNomePorId(turma.getIdProfessor());
//            return new ReadOnlyStringWrapper(nomeProfessor);
//        });
        colunaAlunos.setCellValueFactory(new PropertyValueFactory<>("quantAlunos"));
        carregarTurmas();
    }

    private void carregarTurmas() {
        tabelaTurmas.getItems().clear();
        List<Turma> turmas = turmaDAO.findAll();
        ObservableList<Turma> observableTurmas = FXCollections.observableArrayList(turmas);
        tabelaTurmas.setItems(observableTurmas);
    }

    @FXML
    void handleNovoAluno(ActionEvent event) throws IOException{
        Turma turmaSelecionada = tabelaTurmas.getSelectionModel().getSelectedItem();

        if (turmaSelecionada == null) {
            System.out.println("Nenhuma turma selecionada.");
            return;
        }

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/cadastro/cadastroATurma.fxml"));
        Parent root = loader.load();

        CadastroATurmaController controller = loader.getController();
        controller.setTurmaSelecionada(turmaSelecionada);

        Stage stage = new Stage();
        stage.setTitle("Adicionar Aluno à Turma");
        stage.setScene(new Scene(root));
        stage.showAndWait();
        carregarTurmas();
    }

    @FXML
    void handleNovaTurma(ActionEvent event) throws IOException {
        abrirPopup("cadastro/cadastroTurma.fxml", "Nova Turma", ((Node) event.getSource()).getScene().getWindow());
        carregarTurmas();
    }

    @FXML
    void handleExcluirTurma(ActionEvent event) {
        Turma selecionado = tabelaTurmas.getSelectionModel().getSelectedItem();
        if (selecionado != null) {
            System.out.println("Ação: Excluir Turma: " + selecionado.getNome());
            turmaDAO.remover(selecionado.getId());
            carregarTurmas();
        } else {
            System.out.println("Nenhuma turma selecionada para excluir.");
        }
    }
}
