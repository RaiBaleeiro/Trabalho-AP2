package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MainController {
    @FXML
    private Button btnCadastrarAluno;
    @FXML
    private Button btnListarAlunos;

    @FXML
    public void initialize() {
        btnCadastrarAluno.setOnAction(e -> {
            System.out.println("Abrir tela de cadastro de aluno.");
        });

        btnListarAlunos.setOnAction(e -> {
            System.out.println("Abrir tela de listagem de alunos.");
        });
    }
}
