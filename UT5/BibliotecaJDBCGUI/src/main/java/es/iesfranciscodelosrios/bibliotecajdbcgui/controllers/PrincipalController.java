package es.iesfranciscodelosrios.bibliotecajdbcgui.controllers;

import es.iesfranciscodelosrios.bibliotecajdbcgui.PrincipalApplication;
import es.iesfranciscodelosrios.dao.LibroDAO;
import es.iesfranciscodelosrios.dataaccess.ConnectionBD;
import es.iesfranciscodelosrios.model.Libro;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class PrincipalController {
    public ListView librosListView;
    public Label detalleIdLabel;
    public Label detalleTituloLabel;
    public Label detalleIsbnLabel;
    public Label detalleAutorLabel;

    @FXML
    private void initialize() {
            cargarLibros();

        configurarLista();

    }
    private void cargarLibros() {
        if (ConnectionBD.getConnection() == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Fallo al conectar");
            alert.setContentText("No se ha podido conectar a la Base de datos");
            alert.show();
        } else {
            List<Libro> libros = LibroDAO.findAll();
            librosListView.setItems(FXCollections.observableList(libros));
        }
    }

    private void configurarLista() {
        librosListView.setCellFactory(listView -> new ListCell<Libro>() {
            @Override
            protected void updateItem(Libro libro, boolean empty) {
                super.updateItem(libro, empty);

                if (empty || libro == null) {
                    setText(null);
                    return;
                }

                String nombreAutor = libro.getAutor() == null ? "Sin autor" : libro.getAutor().getNombre();
                setText(libro.getTitulo() + " - " + nombreAutor);
            }
        });
        librosListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
        mostrarLibroEnPanel((Libro) newValue);
        });
    }

    private void mostrarLibroEnPanel(Libro libro) {
        if (libro != null) {
            detalleTituloLabel.setText(libro.getTitulo());
            detalleAutorLabel.setText(libro.getAutor().getNombre());
            detalleIdLabel.setText(String.valueOf(libro.getIdLibro()));
            detalleIsbnLabel.setText(libro.getISBN());
        } else {
            detalleTituloLabel.setText(null);
            detalleAutorLabel.setText(null);
            detalleIdLabel.setText(null);
            detalleIsbnLabel.setText(null);
        }

    }

    public void recargar(ActionEvent actionEvent) {
        cargarLibros();
    }



    private void abrirFormulario() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(PrincipalApplication.class.getResource("formularioLibro-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Añadir libro");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.showAndWait();
    }

    @FXML
    private void anadirNuevoLibro(ActionEvent actionEvent) throws IOException {
        abrirFormulario();
    }
}
