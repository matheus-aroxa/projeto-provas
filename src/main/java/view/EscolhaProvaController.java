package view;

import java.io.IOException;
import java.util.List;

import DAO.ObjectDAO;
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

        Prova selecionado = tabelaProvas.getSelectionModel().getSelectedItem();
        System.out.println(selecionado);

        if (selecionado != null) {
            System.out.println("Ação : Realizar Prova" + selecionado.getTitulo());

            FXMLLoader loader = new FXMLLoader(getClass().getResource("AvaliacaoProvaView.fxml"));
            Parent page = loader.load();
            AvaliacaoProvaController controlador = loader.getController();
            Stage janela = ((Stage) ((Node) event.getSource()).getScene().getWindow());

            controlador.setProva(selecionado);
            janela.setScene(new Scene(page));
            janela.setTitle("Avaliação da prova");

        } else {
            System.out.println("Nenhuma prova selecionada");
        }

//        trocarTela(event, "AvaliacaoProvaView.fxml", "Avaliação");
    }

}
