package es.iesfranciscodelosrios.generadordefrases;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class GeneradorApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(GeneradorApplication.class.getResource("generador-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 250);
        stage.setMinHeight(200);
        stage.setMinWidth(360);
        stage.setTitle("Generador de frases");
        stage.setScene(scene);
        stage.show();
    }
}
