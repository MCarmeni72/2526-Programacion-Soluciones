package es.iesfranciscodelosrios.calculadoradivisas.controllers;

import es.iesfranciscodelosrios.calculadoradivisas.utils.Divisa;
import es.iesfranciscodelosrios.calculadoradivisas.utils.DivisaUtils;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class PrincipalController {
    @FXML
    public RadioButton opcionDolares;
    @FXML
    public RadioButton opcionRublos;
    @FXML
    public RadioButton opcionYuanes;
    @FXML
    public TextField textoEuros;
    @FXML
    public TextField textoDivisa;
    @FXML
    public Button botonConvertir;

    @FXML
    private void convertir() {
        Divisa divisaSeleccionada = obtenerDivisaSeleccionada();
        if (!textoEuros.getText().isEmpty()) {
            double cantidad = Double.parseDouble(textoEuros.getText());
            double cantidadConvertida = DivisaUtils.convertirADivisa(cantidad, divisaSeleccionada);
            textoDivisa.setText(DivisaUtils.formatearCantidad(cantidadConvertida));
        } else if (!textoDivisa.getText().isEmpty()) {
            double cantidad = Double.parseDouble(textoDivisa.getText());
            double cantidadConvertida = DivisaUtils.convertirAEuros(cantidad, divisaSeleccionada);
            textoEuros.setText(DivisaUtils.formatearCantidad(cantidadConvertida));
        }
        // Si euros está relleno, convertir a euros
        // Si euros está vacio, convertir desde divisa.
        System.out.println("Hola");
    }

    private Divisa obtenerDivisaSeleccionada() {
        Divisa divisaSeleccionada = null;
        if (opcionDolares.isSelected()) {
            divisaSeleccionada = Divisa.DOLAR;
        } else if (opcionRublos.isSelected()) {
            divisaSeleccionada = Divisa.RUBLO;
        } else if (opcionYuanes.isSelected()) {
            divisaSeleccionada = Divisa.YUAN;
        }
        return divisaSeleccionada;

    }

    private void actualizarBotones() {
        boolean eurosVacio = textoEuros.getText().isEmpty();
        boolean divisaVacia = textoDivisa.getText().isEmpty();

        if ((eurosVacio && !divisaVacia) || (!eurosVacio && divisaVacia)) {
            botonConvertir.setDisable(false);
        } else {
            botonConvertir.setDisable(true);
        }
    }

    @FXML
    private void initialize() {
        textoEuros.textProperty().addListener(
                (observable, oldValue, newValue) -> actualizarBotones()
        );

        textoDivisa.textProperty().addListener((observable, oldValue, newValue) -> actualizarBotones());
    }
}
