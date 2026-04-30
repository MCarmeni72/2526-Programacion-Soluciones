package es.iesfranciscodelosrios.bibliotecajdbcgui.utils;

import javafx.scene.control.Alert;

public class Utils {

    private Utils() {}

    public static void mostrarError(String titulo, String cabecera, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(titulo);
        alert.setHeaderText(cabecera);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
