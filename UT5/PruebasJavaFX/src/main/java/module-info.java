module es.iesfranciscodelosrios.pruebasjavafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens es.iesfranciscodelosrios.pruebasjavafx to javafx.fxml;
    exports es.iesfranciscodelosrios.pruebasjavafx;
}