package es.iesfranciscodelosrios.bibliotecajdbcgui.controller;

import es.iesfranciscodelosrios.bibliotecajdbcgui.utils.Utils;
import es.iesfranciscodelosrios.dao.AutorDAO;
import es.iesfranciscodelosrios.dao.LibroDAO;
import es.iesfranciscodelosrios.model.Autor;
import es.iesfranciscodelosrios.model.Libro;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.sql.SQLException;
import java.util.List;

public class FormularioLibroController {

    @FXML
    public TextField txtTitulo;
    @FXML
    public TextField txtISBN;
    @FXML
    public ComboBox<Autor> cmbAutor;
    @FXML
    public Label tituloFormularioLabel;
    @FXML
    public Button btnGuardar;
    private Libro libroAEditar;

    public void inicializar(Libro libro) {
        this.libroAEditar = libro;
        cargarAutores();
        configurarComboBoxAutores();
        configurarListeners();
        if (libro != null) {
            txtTitulo.setText(libro.getTitulo());
            txtISBN.setText(libro.getISBN());
            cmbAutor.setValue(libro.getAutor());
            tituloFormularioLabel.setText("Editar libro");
        } else {
            txtTitulo.setText("");
            txtISBN.setText("");
            cmbAutor.setValue(null);
            tituloFormularioLabel.setText("Añadir libro");
        }
        actualizarBotonGuardar();
    }
    @FXML
    private void guardarLibro(ActionEvent actionEvent) {
        try {
            String titulo = txtTitulo.getText();
            Autor autor = cmbAutor.getValue();
            String isbn = txtISBN.getText();

            if (this.libroAEditar == null) {
                Libro libroNuevo = new Libro(titulo, isbn, autor);
                libroNuevo = LibroDAO.addLibro(libroNuevo);
                if (libroNuevo == null) {
                    Utils.mostrarDialogo("Error", "Error al guardar", "No se ha podido guardar el libro", Alert.AlertType.ERROR);
                } else {
                    Stage stage = (Stage) txtTitulo.getScene().getWindow();
                    stage.close();
                }
            } else {
                libroAEditar.setTitulo(titulo);
                libroAEditar.setISBN(isbn);
                libroAEditar.setAutor(autor);
                if (LibroDAO.updateLibro(libroAEditar)) {
                    Stage stage = (Stage) txtTitulo.getScene().getWindow();
                    stage.close();
                } else {
                    Utils.mostrarDialogo("Error", "Error al editar", "No se ha podido editar el libro", Alert.AlertType.ERROR);
                }
            }

        } catch (SQLException e) {
            Utils.mostrarDialogo("Error","Error al relizar la operación", "No se ha podido conectar a la Base de datos: " + e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    private void cargarAutores() {
        try {
            List<Autor> autores = AutorDAO.findAll();
            autores.sort((a1, a2) -> a1.getNombre().compareTo(a2.getNombre()));
            cmbAutor.setItems(FXCollections.observableArrayList(autores));
        } catch (SQLException e) {
            Utils.mostrarDialogo("Error", "Error al cargar", "No se han podido obtener los autores: "+ e.getMessage(), Alert.AlertType.ERROR);
        }

    }

    private void configurarListeners() {
        txtTitulo.textProperty().addListener((observable, oldValue, newValue) -> actualizarBotonGuardar());
        txtISBN.textProperty().addListener((observable, oldValue, newValue) -> actualizarBotonGuardar());
        cmbAutor.valueProperty().addListener((observable, oldValue, newValue) -> actualizarBotonGuardar());
    }

    private void configurarComboBoxAutores() {
        cmbAutor.setCellFactory(listView -> new ListCell<>() {
            @Override
            protected void updateItem(Autor autor, boolean empty) {
                super.updateItem(autor, empty);
                setText(empty || autor == null ? null : autor.getNombre());
            }
        });

        cmbAutor.setButtonCell(new ListCell<>() {
            @Override
            protected void updateItem(Autor autor, boolean empty) {
                super.updateItem(autor, empty);
                setText(empty || autor == null ? null : autor.getNombre());
            }
        });
    }

    public void cerrarVentana(ActionEvent actionEvent) {
        Stage stage = (Stage) txtTitulo.getScene().getWindow();
        stage.close();
    }

    private void actualizarBotonGuardar() {
        btnGuardar.setDisable(!datosValidos());
    }

    private boolean datosValidos() {
        return !txtTitulo.getText().isBlank()
                && !txtISBN.getText().isBlank()
                && cmbAutor.getValue() != null;
    }
}
