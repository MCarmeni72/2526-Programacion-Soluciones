module es.iesfranciscodelosrios.bibliotecajdbcgui {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.xml.bind;
    requires java.sql;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;


    opens es.iesfranciscodelosrios.bibliotecajdbcgui to javafx.fxml;
    exports es.iesfranciscodelosrios.bibliotecajdbcgui;

    opens es.iesfranciscodelosrios.bibliotecajdbcgui.controller to javafx.fxml;
    exports es.iesfranciscodelosrios.bibliotecajdbcgui.controller;

    opens es.iesfranciscodelosrios.dataaccess to java.xml.bind;
    exports es.iesfranciscodelosrios.dataaccess;
}