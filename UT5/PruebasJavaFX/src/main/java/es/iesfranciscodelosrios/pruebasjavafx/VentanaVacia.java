package es.iesfranciscodelosrios.pruebasjavafx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class VentanaVacia extends Application {

    @Override
    public void start(Stage stage) {
        VBox raiz = new VBox();
        raiz.setPadding(new Insets(15));
        raiz.setSpacing(10);
        Label label = new Label("Bienvenido a la aplicación");
        Label label2 = new Label("Primera ventana creada con JavaFX");
        raiz.getChildren().add(label);
        raiz.getChildren().add(label2);
        Scene scene = new Scene(raiz, 400, 250);

        stage.setTitle("Ventana vacía");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}