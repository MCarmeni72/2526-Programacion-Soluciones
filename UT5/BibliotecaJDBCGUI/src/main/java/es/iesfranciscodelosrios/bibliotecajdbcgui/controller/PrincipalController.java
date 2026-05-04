package es.iesfranciscodelosrios.bibliotecajdbcgui.controller;

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
    @FXML
    public ListView<Libro> librosListView;
    @FXML
    public Label detalleIdLabel;
    @FXML
    public Label detalleTituloLabel;
    @FXML
    public Label detalleIsbnLabel;
    @FXML
    public Label detalleAutorLabel;
    @FXML
    public Button btnNuevo;
    @FXML
    public Button btnRecargar;
    @FXML
    public Button btnEditar;
    @FXML
    public Button btnEliminar;

    @FXML
    private void initialize() {
        configurarLista();
        try {
            ConnectionBD.getInstance().connect();
            cargarLibros();
            btnNuevo.setDisable(false);
            btnRecargar.setDisable(false);
            
        } catch (SQLException e) {
            Utils.mostrarDialogo("Error", "Error de conexión", "No se ha podido conectar a la Base de datos: " + e.getMessage(), Alert.AlertType.ERROR);
        }
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
        librosListView.setPlaceholder(new Label("No hay libros para mostrar"));
        btnEliminar.disableProperty().bind(librosListView.getSelectionModel().selectedItemProperty().isNull());
        btnEditar.disableProperty().bind(librosListView.getSelectionModel().selectedItemProperty().isNull());
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
            Utils.mostrarDialogo("Error", "Error al cargar el formulario", "No se ha podido cargar el formulario: " + e.getMessage(), Alert.AlertType.ERROR);
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
            Utils.mostrarDialogo("Error", "No hay libro seleccionado", "Debe seleccionar un libro para eliminar", Alert.AlertType.ERROR);
            return;
        }
        // Vamos a confirmar que se quiera borrar
        Optional<ButtonType> respuesta = Utils.mostrarDialogo("Confirmar borrado", "Confirmar borrado del libro", "¿Está seguro de que desea eliminar el libro '" + libro.getTitulo() + "'?", Alert.AlertType.CONFIRMATION);
        if (respuesta.isPresent() && respuesta.get() == ButtonType.OK) {
            try {
                // borramos de la BD
                LibroDAO.deleteLibroById(libro.getIdLibro());
                // Borramos de nuestra lista.
                librosListView.getItems().remove(libro);
                librosListView.getSelectionModel().clearSelection();
            } catch (SQLException e) {
                Utils.mostrarDialogo("Error", "Error de base de datos", "No se ha podido borrar el libro en la BD: " + e.getMessage(), Alert.AlertType.ERROR);
            }
        }
    }

    @FXML
    public void editarLibroSeleccionado(ActionEvent actionEvent) {
        // Obtener el libro seleccionado
        Libro libro = librosListView.getSelectionModel().getSelectedItem();
        if (libro == null) {
            Utils.mostrarDialogo("Error", "No hay libro seleccionado", "Debe seleccionar un libro para eliminar", Alert.AlertType.ERROR);
            return;
        }

        abrirFormulario(libro);
        cargarLibros();
        librosListView.getSelectionModel().select(libro);
    }

    @FXML
    public void cerrarVentana(ActionEvent actionEvent) {
        Stage stage = (Stage) btnNuevo.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void mostrarAcercaDe(ActionEvent actionEvent) {
        Utils.mostrarDialogo("Acerca de", "Biblioteca - CRUD de libros", "Autor: Alfonso\nVersión: 1.0\nTecnología: JavaFX + JDBC", Alert.AlertType.INFORMATION);
    }
}
