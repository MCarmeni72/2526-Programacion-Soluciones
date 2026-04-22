package es.iesfranciscodelosrios.calculadoradivisas.controllers;

import es.iesfranciscodelosrios.calculadoradivisas.utils.Divisa;
import es.iesfranciscodelosrios.calculadoradivisas.utils.DivisaUtils;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

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
    public Button botonLimpiar;

    @FXML
    private void convertir() {
        Divisa divisaSeleccionada = obtenerDivisaSeleccionada();
        if (!textoEuros.getText().isEmpty()) {
            double cantidad = Double.parseDouble(textoEuros.getText().replace(",", "."));
            double cantidadConvertida = DivisaUtils.convertirADivisa(cantidad, divisaSeleccionada);
            textoDivisa.setText(DivisaUtils.formatearCantidad(cantidadConvertida));
        } else if (!textoDivisa.getText().isEmpty()) {
            double cantidad = Double.parseDouble(textoDivisa.getText().replace(",", "."));
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

        botonConvertir.setDisable((!eurosVacio || divisaVacia) && (eurosVacio || !divisaVacia));

        botonLimpiar.setDisable(eurosVacio && divisaVacia);
    }

    @FXML
    private void limpiar() {
        textoEuros.setText("");
        textoDivisa.setText("");
        opcionDolares.setSelected(true);
        actualizarBotones();
    }

    @FXML
    private void initialize() {
        controlarCampoNumérico(this.textoEuros);
        controlarCampoNumérico(this.textoDivisa);
    }

    private void controlarCampoNumérico(TextField campo) {
        campo.textProperty().addListener(
                (observable, oldValue, newValue) -> {
                    if (!newValue.matches("\\d*([.,]\\d*)?")) {
                        campo.setText(oldValue);
                    }
                    actualizarBotones();
                }
        );
    }

    @FXML
    private void mostrarAcercaDe() {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("Acerca de Calculadora de Divisas");
        alerta.setHeaderText("Calculadora de Divisas");
        alerta.setContentText("""
                   Aplicación didáctica realizada con JavaFX, FXML y Maven.
                   Convierte euros a dólares, rublos o yuanes, y también en sentido inverso.
                   Versión: 1.0""");
        alerta.showAndWait();
    }

    @FXML
    private void salir() {
        Stage stage = (Stage) textoEuros.getScene().getWindow();
        stage.close();
    }
}
