package view;

import java.io.IOException;
import java.util.List;

import DAO.ObjectDAO;
import DAO.ProvaDAOImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import models.provas.Prova;

public class EscolhaProvaController extends FuncoesComuns {

    @FXML
    private TableView<Prova> tabelaProvas;
    @FXML
    private TableColumn<Prova, Integer> colunaId;
    @FXML
    private TableColumn<Prova, String> colunaTitulo;
    @FXML
    private TableColumn<Prova, String> colunaData;
    @FXML
    private TableColumn<Prova, String> colunaTipo;

    private ObjectDAO<Prova> provaDAO = new ProvaDAOImpl();

    @FXML
    public void initialize(){
        colunaId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colunaTitulo.setCellValueFactory(new PropertyValueFactory<>("titulo"));
        colunaData.setCellValueFactory(new PropertyValueFactory<>("dataAplicacao"));
        colunaTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        carregarProvas();
    }


    private void carregarProvas(){
        tabelaProvas.getItems().clear();
        List<Prova> provas = provaDAO.findAll();
        ObservableList<Prova> observableProvas = FXCollections.observableArrayList(provas);
        tabelaProvas.setItems(observableProvas);
    }


    @FXML
    void handleVoltar(ActionEvent event) throws IOException {
        trocarTela(event, "AlunoDashboardView.fxml", "Menu do Aluno");
    }

    @FXML
    void handleSair(ActionEvent event) throws IOException {
        trocarTela(event, "login.fxml", "Login");
    }

    @FXML
    void handleRealizarProva(ActionEvent event) throws IOException {
        trocarTela(event, "AvaliacaoProvaView.fxml", "Avaliação");
    }

}
