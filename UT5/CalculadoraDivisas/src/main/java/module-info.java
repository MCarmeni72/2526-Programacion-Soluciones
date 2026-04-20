module es.iesfranciscodelosrios.calculadoradivisas {
    requires javafx.controls;
    requires javafx.fxml;


    opens es.iesfranciscodelosrios.calculadoradivisas to javafx.fxml;
    exports es.iesfranciscodelosrios.calculadoradivisas;
    exports es.iesfranciscodelosrios.calculadoradivisas.controllers;
    opens es.iesfranciscodelosrios.calculadoradivisas.controllers to javafx.fxml;
}