package controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import model.Aluno;
import model.Academia;

public class CadastroAlunoController {
    @FXML
    private TextField txtNome;
    @FXML
    private TextField txtIdade;
    @FXML
    private TextField txtPeso;
    @FXML
    private TextField txtAltura;
    @FXML
    private TextField txtObjetivo;
    @FXML
    private Button btnSalvar;

    private Academia academia = new Academia();

    @FXML
    public void initialize() {
        btnSalvar.setOnAction(e -> salvarAluno());
    }

    private void salvarAluno() {
        try {
            String nome = txtNome.getText();
            int idade = Integer.parseInt(txtIdade.getText());
            double peso = Double.parseDouble(txtPeso.getText());
            double altura = Double.parseDouble(txtAltura.getText());
            String objetivo = txtObjetivo.getText();

            Aluno aluno = new Aluno(nome, idade, peso, altura, objetivo);
            academia.cadastrarAluno(aluno);

            System.out.println("Aluno cadastrado com sucesso!");
        } catch (NumberFormatException ex) {
            System.out.println("Erro: Verifique os campos numéricos (idade, peso, altura)." + ex.getMessage());
        }
    }
}
