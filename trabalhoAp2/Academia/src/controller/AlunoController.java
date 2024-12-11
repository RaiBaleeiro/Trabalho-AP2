package controller;


import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;
import model.Aluno;
import utils.RepositorioAluno;

public class AlunoController extends MainController {
    @FXML
    private TableView<Aluno> tableAluno;
    @FXML
    private TableColumn<Aluno, Integer> tableColumnAlunoId;
    @FXML
    private TableColumn<Aluno, String> tableColumnAlunoNome;
    @FXML
    private TableColumn<Aluno, String> tableColumnAlunoPlano;
    @FXML
    private TableColumn<Aluno, String> tableColumnAlunoCpf;
    @FXML
    private TextField textFieldPesquisarAluno;

    private RepositorioAluno repositorioAluno = new RepositorioAluno();
    private ObservableList<Aluno> alunos = FXCollections.observableArrayList();
    private FichaController fichaController = new FichaController();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tableColumnAlunoId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tableColumnAlunoNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tableColumnAlunoPlano.setCellValueFactory(new PropertyValueFactory<>("plano"));
        tableColumnAlunoCpf.setCellValueFactory(new PropertyValueFactory<>("cpf"));

        alunos.addAll(repositorioAluno.getAllAlunos());

        //Permite abrir um aluno pela tabela com duplo clique
        tableAluno.setRowFactory( new Callback<TableView<Aluno>, TableRow<Aluno>>() {
            @Override
            public TableRow<Aluno> call(TableView<Aluno> tableView) {
                final TableRow<Aluno> row = new TableRow<>();
                row.setOnMouseClicked(new EventHandler<MouseEvent>(){
                    @Override
                    public void handle(MouseEvent event) {
                        if (event.getClickCount() == 2 && !row.isEmpty()) {
                            Aluno aluno = row.getItem();
                            JOptionPane.showMessageDialog(
                                null,
                                fichaController.toString(aluno) + 
                                "\n\nTreino do dia\n-------------------------------\n" + aluno.getTreino(),
                                aluno.getNome(),
                                1
                            );
                        }
                    }
                });
                return row;
            }
        });
        

        //Adiciona a lista inteira à lista filtrada
        FilteredList<Aluno> filteredData = new FilteredList<>(alunos, b -> true);

        textFieldPesquisarAluno.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(aluno -> {
                
                //Se o filtro estiver vazio mostra todo mundo
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                //String para comparação
                String lowerCaseFilter = newValue.toLowerCase();

                //Mostra todos os itens de pesquisa que incluem a String de comparação
                if (aluno.getNome().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else if (aluno.getPlano().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else if (String.valueOf(aluno.getCpf()).indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else {
                    return false;
                }
            });
        });

        SortedList<Aluno> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(tableAluno.comparatorProperty());
        tableAluno.setItems(sortedData);
    }
}