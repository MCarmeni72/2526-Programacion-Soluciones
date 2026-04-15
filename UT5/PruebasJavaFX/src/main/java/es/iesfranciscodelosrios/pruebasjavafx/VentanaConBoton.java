package es.iesfranciscodelosrios.pruebasjavafx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class VentanaConBoton extends Application {

    @Override
    public void start(Stage stage) {
        VBox raiz = new VBox();
        raiz.setSpacing(10);
        raiz.setPadding(new Insets(15));

        Label mensaje = new Label("Escribe tu nombre");
        TextField textoNombre = new TextField();
        Button boton = new Button("Haz clic");

        boton.setOnAction(e -> {
            System.out.println(e.getSource());
            mensaje.setText("Hola, " + textoNombre.getText() + "!");
        });

        raiz.getChildren().addAll(mensaje, textoNombre, boton);

        Scene scene = new Scene(raiz, 400, 200);

        stage.setTitle("Saludo");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}