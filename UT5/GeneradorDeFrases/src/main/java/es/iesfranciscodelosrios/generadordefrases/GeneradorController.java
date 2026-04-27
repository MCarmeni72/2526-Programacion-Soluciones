package es.iesfranciscodelosrios.generadordefrases;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class GeneradorController {

    @FXML
    public RadioButton rbPorDefecto;
    @FXML
    public RadioButton rbPersonalizado;
    @FXML
    public TextField txtFrase;
    @FXML
    public Button btnGenerar;
    @FXML
    public Button btnLimpiar;
    @FXML
    public TextArea taTextoGenerado;
    @FXML
    public Spinner spnRepeticiones;

    @FXML
    private void initialize() {
        rbPersonalizado.selectedProperty().addListener((observable, oldValue, newValue) -> {
            txtFrase.setDisable(!newValue);
            gestionarBotonGenerar();
        });
        txtFrase.textProperty().addListener((observable, oldValue, newValue) -> {
            gestionarBotonGenerar();
        });

//        taTextoGenerado.textProperty().addListener((observable, oldValue, newValue) -> {
//            btnLimpiar.setDisable(newValue.isEmpty());
//        });
        btnLimpiar.disableProperty().bind(taTextoGenerado.textProperty().isEmpty());
    }

    private void gestionarBotonGenerar() {
        btnGenerar.setDisable(rbPersonalizado.isSelected() && txtFrase.getText().isEmpty());
    }

    @FXML
    private void generarFrase() {
        // Averiguar frase
        String fraseEscogida = "Lorem ipsum dolor sit amet";
        if (rbPersonalizado.isSelected()) {
            fraseEscogida = txtFrase.getText();
        }
        taTextoGenerado.setText(fraseEscogida.repeat((Integer) spnRepeticiones.getValue()));
    }

    @FXML
    private void limpiar() {
        taTextoGenerado.clear();
    }

    public void salir(ActionEvent actionEvent) {
        Stage stage = (Stage) spnRepeticiones.getScene().getWindow();
        stage.close();
    }

    public void mostrarAcercaDe(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Acerca de...");
        alert.setHeaderText("Acerca de Generador de Frases");
        alert.setContentText("""
                Generador de Frases 1.0
                Desarrollado por Alfonso Jiménez
                """);
        alert.showAndWait();
    }
}
