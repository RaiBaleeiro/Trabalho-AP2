package controller;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class MainController implements Initializable {
    @FXML
    private Button Plano;
    @FXML
    private Button Cadastro;
    @FXML
    private Button Aluno;
    @FXML
    private AnchorPane anchorPane;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void handleButtonAluno(ActionEvent event) {
        AnchorPane a;
        try {
            a = (AnchorPane)FXMLLoader.load(getClass().getResource("/view/AlunoView.fxml"));
            anchorPane.getChildren().setAll(a);
        } catch (IOException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void handleButtonCadastro(ActionEvent event) {
        AnchorPane a;
        try {
            a = (AnchorPane)FXMLLoader.load(getClass().getResource("/view/CadastroView.fxml"));
            anchorPane.getChildren().setAll(a);
        } catch (IOException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void handleButtonPlano(ActionEvent event) {
        AnchorPane a;
        try {
            a = (AnchorPane)FXMLLoader.load(getClass().getResource("/view/PlanoView.fxml"));
            anchorPane.getChildren().setAll(a);
        } catch (IOException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
