module es.iesfranciscodelosrios.bibliotecajdbcgui {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.xml.bind;
    requires java.sql;


    opens es.iesfranciscodelosrios.bibliotecajdbcgui to javafx.fxml;
    exports es.iesfranciscodelosrios.bibliotecajdbcgui;

    opens es.iesfranciscodelosrios.bibliotecajdbcgui.controllers to javafx.fxml;
    exports es.iesfranciscodelosrios.bibliotecajdbcgui.controllers;

    opens es.iesfranciscodelosrios.dataaccess to java.xml.bind;
    exports es.iesfranciscodelosrios.dataaccess;
}