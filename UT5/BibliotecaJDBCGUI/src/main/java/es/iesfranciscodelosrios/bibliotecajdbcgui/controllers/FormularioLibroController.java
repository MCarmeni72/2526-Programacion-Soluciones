package es.iesfranciscodelosrios.bibliotecajdbcgui.controllers;

import es.iesfranciscodelosrios.bibliotecajdbcgui.utils.Utils;
import es.iesfranciscodelosrios.dao.AutorDAO;
import es.iesfranciscodelosrios.dao.LibroDAO;
import es.iesfranciscodelosrios.model.Autor;
import es.iesfranciscodelosrios.model.Libro;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.SQLException;
import java.util.List;

public class FormularioLibroController {

    public TextField txtTitulo;
    public TextField txtISBN;
    public ComboBox<Autor> cmbAutor;
    private Libro libroAEditar;

    public void inicializar(Libro libro) {
        this.libroAEditar = libro;
        cargarAutores();
        configurarComboBoxAutores();
        if (libro != null) {
            txtTitulo.setText(libro.getTitulo());
            txtISBN.setText(libro.getISBN());
            cmbAutor.setValue(libro.getAutor());
        } else {
            txtTitulo.setText("");
            txtISBN.setText("");
            cmbAutor.setValue(null);
        }
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
                    Utils.mostrarError("Error", "Error al guardar", "No se ha podido guardar el libro");
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
                    Utils.mostrarError("Error", "Error al editar", "No se ha podido editar el libro");
                }
            }

        } catch (SQLException e) {
            Utils.mostrarError("Error","Error al relizar la operación", "No se ha podido conectar a la Base de datos: " + e.getMessage());
        }
    }

    private void cargarAutores() {
        try {
            List<Autor> autores = AutorDAO.findAll();
            autores.sort((a1, a2) -> a1.getNombre().compareTo(a2.getNombre()));
            cmbAutor.setItems(FXCollections.observableArrayList(autores));
        } catch (SQLException e) {
            Utils.mostrarError("Error", "Error al cargar", "No se han podido obtener los autores: "+ e.getMessage());
        }

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
}
