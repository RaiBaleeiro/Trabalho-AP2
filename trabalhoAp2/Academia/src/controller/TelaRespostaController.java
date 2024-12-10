package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.Stage;

public class TelaRespostaController implements Initializable {
    private Stage dialogStage;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    public void setDialogStage (Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    //Fecha a caixa de diálogo
    @FXML
    private void confirmar(ActionEvent event) {
        this.dialogStage.close();
    }
}
