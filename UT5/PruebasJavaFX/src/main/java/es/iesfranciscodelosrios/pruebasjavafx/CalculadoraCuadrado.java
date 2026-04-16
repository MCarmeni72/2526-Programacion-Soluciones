package es.iesfranciscodelosrios.pruebasjavafx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CalculadoraCuadrado extends Application {

    @Override
    public void start(Stage stage) {
        VBox raiz = new VBox();
        raiz.setSpacing(10);
        raiz.setPadding(new Insets(15));

        Label mensaje = new Label("Escribe un número:");
        Label mensajeResultado = new Label("");
        TextField textoNumero = new TextField();
        Button boton = new Button("Calcular");

        boton.setOnAction(e -> {
            System.out.println(e.getSource());
            double numero = Double.parseDouble(textoNumero.getText());
            mensajeResultado.setText("El número " + numero + " elevado al cuadrado es " + (numero * numero));
        });

        raiz.getChildren().addAll(mensaje, textoNumero, boton, mensajeResultado);

        Scene scene = new Scene(raiz, 400, 200);

        stage.setTitle("Calculadora de cuadrados");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}