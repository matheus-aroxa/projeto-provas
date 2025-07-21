package view;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import DAO.ProvaDAO;
import DAO.ProvaDAOImpl;
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
import models.provas.Prova;
import view.cadastro.CadastroProvaController;

public class GerenciarProvasController extends FuncoesComuns{

    @FXML
    private TableView<Prova> tabelaProvas;
    @FXML
    private TableColumn<Prova, String> colunaTitulo;
    @FXML
    private TableColumn<Prova, Integer> colunaId;
    @FXML
    private TableColumn<Prova, String> colunaTipo;
    @FXML
    private TableColumn<Prova ,LocalDateTime> colunaData;


    private ProvaDAO provaDAO = new ProvaDAOImpl();

    @FXML
    public void initialize(){
        colunaId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colunaTitulo.setCellValueFactory(new PropertyValueFactory<>("titulo"));
        colunaTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        colunaData.setCellValueFactory(new PropertyValueFactory<>("dataAplicacao"));
        carregaProvas();
    }

    private void carregaProvas(){
        tabelaProvas.getItems().clear();
        List<Prova> provas = provaDAO.findAll();
        ObservableList<Prova> observableProvas = FXCollections.observableArrayList(provas);
        tabelaProvas.setItems(observableProvas);
    }


    @FXML
    void handleNovaProva(ActionEvent event) throws IOException {
        trocarTela(event, "cadastro/cadastroProva.fxml", "Cadastro da Prova");
    }

    @FXML
    void handleEditarProva(ActionEvent event) throws IOException {
        Prova selecionado = tabelaProvas.getSelectionModel().getSelectedItem();

        if (selecionado != null) {
            System.out.println("Ação : Editar Prova" + selecionado.getTitulo());

            FXMLLoader loader = new FXMLLoader(getClass().getResource("cadastro/cadastroProva.fxml"));
            Parent page = loader.load();
            CadastroProvaController controlador = loader.getController();
            Stage janela = ((Stage) ((Node) event.getSource()).getScene().getWindow());

            controlador.setProva(selecionado);
            janela.setScene(new Scene(page));
            janela.setTitle("Edição da prova");

        }else{
            System.out.println("Nenhuma prova selecionada");
        }

    }

    @FXML
    void handleEnviarProva(ActionEvent event) throws IOException {
        trocarTela(event, "EnvioProvaView.fxml", "Enviar Prova");
    }

    @FXML
    void handleExcluirProva(ActionEvent event) throws IOException {
        Prova selecionado = tabelaProvas.getSelectionModel().getSelectedItem();
        if(selecionado != null){
            System.out.println("Ação: Excluir Prova: "+selecionado.getTitulo());
            provaDAO.removerProva(selecionado.getId());
            carregaProvas();
        }else{
            System.out.println("Nenhuma prova selecionada para excluir");
        }
    }
}
