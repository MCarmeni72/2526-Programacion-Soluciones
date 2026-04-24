module es.iesfranciscodelosrios.generadordefrases {
    requires javafx.controls;
    requires javafx.fxml;


    opens es.iesfranciscodelosrios.generadordefrases to javafx.fxml;
    exports es.iesfranciscodelosrios.generadordefrases;
}