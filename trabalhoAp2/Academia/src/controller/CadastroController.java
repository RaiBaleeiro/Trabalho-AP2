package controller;

import utils.RepositorioAluno;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
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
    private ChoiceBox<String> textFieldNivelAluno;
    @FXML
    private TextField textFieldCpfAluno;
    @FXML
    private Button buttonCadastarAluno;
    @FXML
    private Button buttonCancelarAluno;

    private RepositorioAluno repositorioAluno = new RepositorioAluno();
    private ArrayList<Aluno> alunos = new ArrayList<>();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        alunos.addAll(repositorioAluno.getAllAlunos());
        textFieldPlanoAluno.getItems().addAll("Básico", "Black");
        textFieldNivelAluno.getItems().addAll("Iniciante", "Avançado");
        limparCampos();
    }

    //Nome autoexplicativo
    private void limparCampos() {
        textFieldNomeAluno.setText("");;
        textFieldIdadeAluno.setText("");
        textFieldPesoAluno.setText("");
        textFieldAlturaAluno.setText("");
        textFieldPlanoAluno.setValue("Básico");
        textFieldNivelAluno.setValue("Iniciante");
        textFieldCpfAluno.setText("");
        textFieldNomeAluno.requestFocus();
    }

    public void popup(String fxml, String msg) {
        try {
            // Carrega o arquivo fxml e cria um novo stage para a janela popup.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(TelaRespostaController.class.getResource(fxml));
            AnchorPane page = (AnchorPane) loader.load();

            // Cria o palco dialogStage
            Stage dialogStage = new Stage();
            //enquanto essa janela estiver aberta, o usuário não pode interagir com a janela principal.
            dialogStage.initModality(Modality.APPLICATION_MODAL);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);
            TelaRespostaController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            dialogStage.setResizable(false);
            dialogStage.showAndWait();
        } catch (IOException ex) {
            Logger.getLogger(CadastroController.class.getName()).log(Level.SEVERE, msg, ex);
        }
    }

    @FXML
    private void handleCadastrarAluno(ActionEvent event) {
        boolean alunoCadastrado = false;

        //Verifica se todos os campos foram preenchidos antes de criar um novo aluno
        if (!textFieldNomeAluno.getText().isEmpty() && !textFieldIdadeAluno.getText().isEmpty()
                && !textFieldPesoAluno.getText().isEmpty() && !textFieldAlturaAluno.getText().isEmpty()
                && !textFieldCpfAluno.getText().isEmpty()) {
            String nome = textFieldNomeAluno.getText().toUpperCase();
            int idade = Integer.parseInt(textFieldIdadeAluno.getText());
            double peso = Double.parseDouble(textFieldPesoAluno.getText());
            double altura = Double.parseDouble(textFieldAlturaAluno.getText());
            String plano = textFieldPlanoAluno.getValue().toString();
            String nivel = textFieldNivelAluno.getValue().toString().toUpperCase();
            String cpf = textFieldCpfAluno.getText();

            //Verifica se existe um aluno cadastrado com o cpf informado
            for (Aluno aluno : alunos) {
                if (aluno.getCpf().equals(cpf)) {
                    alunoCadastrado = true;
                    popup("/view/AlunoCadastradoView.fxml", null);
                    break;
                }
            }

            //Cadastra o novo aluno e atualiza, salva no arquivo e atualiza a lista local
            if (!alunoCadastrado) {
                repositorioAluno.createAluno(new Aluno (nome, idade, peso, altura, plano, nivel, cpf));
                alunos.add(repositorioAluno.getAllAlunos().getLast());
                popup("/view/ExitoView.fxml", "CadastrarAluno falhou");
            }

            limparCampos();
        } else {
            popup("/view/CamposInvalidosView.fxml", null);
        }
    }
}
