package view;

import DAO.ProfessorDAO;
import DAO.ProfessorDAOImpl;
import DAO.TurmaDAO;
import DAO.TurmaDAOlmpl;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import models.Turma;
import models.usuarios.Usuario;

import java.io.IOException;
import java.util.List;

public class GerenciarTurmaController extends FuncoesComuns{

    @FXML
    private TableView<Turma> tabelaTurmas;
    @FXML
    private TableColumn<Turma, Integer> colunaId;
    @FXML
    private TableColumn<Turma, String> colunaNome;
    @FXML
    private TableColumn<Turma, String> colunaProfessor;
    @FXML
    private TableColumn<Turma, Integer> colunaAlunos;

    private TurmaDAO turmaDAO = new TurmaDAOlmpl();
    private ProfessorDAO professorDAO = new ProfessorDAOImpl();

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
        Turma[] turmas = turmaDAO.getAllTurmas();
        ObservableList<Turma> observableTurmas = FXCollections.observableArrayList(turmas);
        tabelaTurmas.setItems(observableTurmas);
    }

    @FXML
    void handleNovoAluno(ActionEvent event){
        trocarTela(event, "cadastro/cadastroATurma.fxml", "Cadastro de Turma");
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
