package view;

import java.io.IOException;

import DAO.QuestaoDAO;
import DAO.QuestaoDAOImpl;
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
import models.provas.Prova;
import models.provas.Questao;
import services.QuestaoService;
import view.cadastro.CadastroProvaController;
import view.cadastro.CadastroQuestaoController;

public class GerenciarQuestoesController extends FuncoesComuns {

    private Prova prova;

    @FXML
    private TableView<Questao> tabelaQuestoes;
    @FXML
    private TableColumn<Questao, String> colunaEnunciado;
    @FXML
    private TableColumn<Questao, Integer> colunaId;

    public void setProva(Prova prova){
        this.prova = prova;
    }

    private QuestaoDAO questaoDAO = new QuestaoDAOImpl();
    private QuestaoService service = new QuestaoService();

    @FXML
    public void initialize(){
        colunaEnunciado.setCellValueFactory(new PropertyValueFactory<>("enunciado"));
        colunaId.setCellValueFactory(new PropertyValueFactory<>("id"));
    }

    public void carregaQuestoes(){
        tabelaQuestoes.getItems().clear();
        service.getQuestoesProva(prova.getId());
    }

    @FXML
    void handleVoltar(ActionEvent event) throws IOException {
        
            FXMLLoader loader = new FXMLLoader(getClass().getResource("cadastro/cadastroProva.fxml"));
            Parent page = loader.load();
            CadastroProvaController controlador = loader.getController();
            Stage janela = ((Stage) ((Node) event.getSource()).getScene().getWindow());

            controlador.setProva(prova);
            janela.setScene(new Scene(page));
            janela.setTitle("Edição da prova");

    }

    @FXML
    void handleAdicionarQuestao(ActionEvent event) throws IOException {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("cadastro/cadastroQuestao.fxml"));
            Parent page = loader.load();
            CadastroProvaController controlador = loader.getController();
            Stage janela = ((Stage) ((Node) event.getSource()).getScene().getWindow());
            controlador.setProva(prova);
            janela.setScene(new Scene(page));

    }

    @FXML
    void handleEditarQuestao(ActionEvent event) throws IOException {
        Questao selecionado = tabelaQuestoes.getSelectionModel().getSelectedItem();

        if (selecionado != null) {
            System.out.println("Ação : Editar Prova" + selecionado.getEnunciado());

            FXMLLoader loader = new FXMLLoader(getClass().getResource("cadastro/cadastroQuestao.fxml"));
            Parent page = loader.load();
            CadastroQuestaoController controlador = loader.getController();
            Stage janela = ((Stage) ((Node) event.getSource()).getScene().getWindow());

            controlador.setQuestao(selecionado);
            janela.setScene(new Scene(page));
            janela.setTitle("Edição da Questão");
        }else{
            System.out.println("Nenhuma prova selecionada");
        }
    }

    @FXML
    void handleCadastrarQuestoes(ActionEvent event) throws IOException {
        trocarTela(event, "/view/ProfessorDashboardView.fxml", "Gerenciar Provas");
    }
}
