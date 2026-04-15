package es.iesfranciscodelosrios.pruebasjavafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class HolaJavaFX extends Application { // Indica que nuestra clase es una aplicación JavaFX.

    @Override
    public void start(Stage stage) { // Aquí configuramos la ventana principal.
        Label etiqueta = new Label("Hola, JavaFX"); // Creamos un control visual de tipo etiqueta.

        /*
        Creamos una escena con:
            * nodo raíz: la etiqueta,
            * anchura: 300,
            * altura: 200.
        */
        Scene escena = new Scene(etiqueta, 300, 200);

        stage.setTitle("Mi primera app JavaFX"); // Ponemos el título de la ventana.
        stage.setScene(escena); // Asignamos la escena a la ventana.
        stage.show(); // Mostramos la ventana.
    }

    public static void main(String[] args) {
        launch(args); // Inicia la aplicación JavaFX al ser ejecutado.
    }
}