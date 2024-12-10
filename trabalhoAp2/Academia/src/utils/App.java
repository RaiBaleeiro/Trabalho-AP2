package utils;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    public void start(Stage stage) {
        try {
            //Setting Background
            Parent root = FXMLLoader.load(getClass().getResource("/view/MainView.fxml"));
            Scene scene = new Scene(root);
            
            stage.setTitle("Acadêmico");
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

}
