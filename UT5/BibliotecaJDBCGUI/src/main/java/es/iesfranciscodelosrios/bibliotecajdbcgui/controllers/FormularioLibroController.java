package es.iesfranciscodelosrios.bibliotecajdbcgui.controllers;

import es.iesfranciscodelosrios.dao.AutorDAO;
import es.iesfranciscodelosrios.dao.LibroDAO;
import es.iesfranciscodelosrios.model.Autor;
import es.iesfranciscodelosrios.model.Libro;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class FormularioLibroController {

    public TextField txtTitulo;
    public TextField txtAutor;
    public TextField txtISBN;

    @FXML
    private void guardarLibro(ActionEvent actionEvent) {
        String titulo = txtTitulo.getText();
        int idAutor = Integer.valueOf(txtAutor.getText());
        Autor autor = AutorDAO.findById(idAutor);
        String isbn = txtISBN.getText();
        Libro libroNuevo = new Libro(titulo, isbn, autor);
        LibroDAO.addLibro(libroNuevo);
        Stage stage = (Stage) txtTitulo.getScene().getWindow();
        stage.close();
    }
}
