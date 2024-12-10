package controller;

import utils.RepositorioAluno;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.Aluno;

public class CadastroController extends MainController {
    @FXML
    private TextField textFieldNomeAluno;
    @FXML
    private TextField textFieldIdadeAluno;
    @FXML
    private TextField textFieldPesoAluno;
    @FXML
    private TextField textFieldAlturaAluno;
    @FXML
    private ChoiceBox<String> textFieldPlanoAluno;
    @FXML
    private TextField textFieldCpfAluno;
    @FXML
    private Button buttonCadastarAluno;
    @FXML
    private Button buttonCancelarAluno;
    @FXML
    private Label labelStatusCadastroAluno;

    private RepositorioAluno repositorioAluno = new RepositorioAluno();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        textFieldPlanoAluno.getItems().addAll("Básico", "Black");
        limparCampos();
    }

    private void limparCampos() {
        textFieldNomeAluno.setText("");;
        textFieldIdadeAluno.setText("");
        textFieldPesoAluno.setText("");
        textFieldAlturaAluno.setText("");
        textFieldPlanoAluno.setValue("Básico");
        textFieldCpfAluno.setText("");
        labelStatusCadastroAluno.setText("");
        textFieldNomeAluno.requestFocus();
    }

    @FXML
    private void handleCadastrarAluno(ActionEvent event) {
        //Verifica se todos os campos foram preenchidos
        if (!textFieldNomeAluno.getText().isEmpty() && !textFieldIdadeAluno.getText().isEmpty()
                && !textFieldPesoAluno.getText().isEmpty() && !textFieldAlturaAluno.getText().isEmpty()
                && !textFieldCpfAluno.getText().isEmpty()) {
            String nome = textFieldNomeAluno.getText().toUpperCase();
            int idade = Integer.parseInt(textFieldIdadeAluno.getText());
            double peso = Double.parseDouble(textFieldPesoAluno.getText());
            double altura = Double.parseDouble(textFieldAlturaAluno.getText());
            String plano = textFieldPlanoAluno.getValue().toString();
            String cpf = textFieldCpfAluno.getText();
            repositorioAluno.createAluno(new Aluno (nome, idade, peso, altura, plano, cpf));
        } else {
            labelStatusCadastroAluno.setText("Dados inválidos");
            textFieldNomeAluno.requestFocus();
        }
        limparCampos();
    }
}
