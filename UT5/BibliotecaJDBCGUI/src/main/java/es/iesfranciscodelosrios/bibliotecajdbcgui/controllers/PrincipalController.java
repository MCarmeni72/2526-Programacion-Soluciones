package es.iesfranciscodelosrios.bibliotecajdbcgui.controllers;

import es.iesfranciscodelosrios.bibliotecajdbcgui.PrincipalApplication;
import es.iesfranciscodelosrios.bibliotecajdbcgui.utils.Utils;
import es.iesfranciscodelosrios.dao.LibroDAO;
import es.iesfranciscodelosrios.dataaccess.ConnectionBD;
import es.iesfranciscodelosrios.model.Libro;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.kordamp.bootstrapfx.BootstrapFX;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class PrincipalController {
    public ListView<Libro> librosListView;
    public Label detalleIdLabel;
    public Label detalleTituloLabel;
    public Label detalleIsbnLabel;
    public Label detalleAutorLabel;

    @FXML
    private void initialize() {
        try {
            ConnectionBD.getInstance().connect();
            cargarLibros();
        } catch (SQLException e) {
            Utils.mostrarError("Error", "Error de conexión", "No se ha podido conectar a la Base de datos: " + e.getMessage());
        }
        configurarLista();

    }

    private void cargarLibros() {
        List<Libro> libros = LibroDAO.findAll();
        librosListView.setItems(FXCollections.observableList(libros));

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



    private void abrirFormulario( Libro libroSeleccionado) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(PrincipalApplication.class.getResource("formularioLibro-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            scene.getStylesheets().add(BootstrapFX.bootstrapFXStylesheet());
            FormularioLibroController controller = fxmlLoader.getController();
            controller.inicializar(libroSeleccionado);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle(libroSeleccionado == null ? "Nuevo libro" : "Editar libro");
            stage.setScene(scene);
            stage.setResizable(false);
            stage.showAndWait();
        } catch (IOException e) {
            Utils.mostrarError("Error", "Error al cargar el formulario", "No se ha podido cargar el formulario: " + e.getMessage());
        }
    }

    @FXML
    private void anadirNuevoLibro(ActionEvent actionEvent) {
        abrirFormulario(null);
        cargarLibros();
    }

    @FXML
    public void eliminarLibroSeleccionado(ActionEvent actionEvent) {
        // Obtener el libro seleccionado
        Libro libro = librosListView.getSelectionModel().getSelectedItem();
        if (libro == null) {
            Utils.mostrarError("Error", "No hay libro seleccionado", "Debe seleccionar un libro para eliminar");
            return;
        }
        // Vamos a confirmar que se quiera borrar
        Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
        alerta.setTitle("Confirmar borrado");
        alerta.setHeaderText("Confirmar borrado del libro");
        alerta.setContentText("¿Está seguro de que desea eliminar el libro '" + libro.getTitulo() + "'?");
        Optional<ButtonType> respuesta = alerta.showAndWait();
        if (respuesta.isPresent() && respuesta.get() == ButtonType.OK) {
            try {
                // borramos de la BD
                LibroDAO.deleteLibroById(libro.getIdLibro());
                // Borramos de nuestra lista.
                librosListView.getItems().remove(libro);
            } catch (SQLException e) {
                Utils.mostrarError("Error", "Error de base de datos", "No se ha podido borrar el libro en la BD: " + e.getMessage());
            }
        }
    }

    @FXML
    public void editarLibroSeleccionado(ActionEvent actionEvent) {
        // Obtener el libro seleccionado
        Libro libro = librosListView.getSelectionModel().getSelectedItem();
        if (libro == null) {
            Utils.mostrarError("Error", "No hay libro seleccionado", "Debe seleccionar un libro para eliminar");
            return;
        }

        abrirFormulario(libro);
        cargarLibros();
    }
}
