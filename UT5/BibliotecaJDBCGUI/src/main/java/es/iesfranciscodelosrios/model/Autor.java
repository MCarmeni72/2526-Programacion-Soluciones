package es.iesfranciscodelosrios.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Autor {
    private int idAutor;
    private String nombre;
    private ArrayList<Libro> libros;

    public Autor(int idAutor, String nombre) {
        this.idAutor = idAutor;
        this.nombre = nombre;
    }

    public Autor(int idAutor, String nombre, List<Libro> libros) {
        this.idAutor = idAutor;
        this.nombre = nombre;
        this.libros = (ArrayList<Libro>) libros;
    }

    public int getIdAutor() {
        return idAutor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setIdAutor(int idAutor) {
        this.idAutor = idAutor;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Autor{" + "idAutor=" + idAutor + ", nombre=" + nombre +", libros=" + libros + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Autor)) return false;
        Autor autor = (Autor) o;
        return idAutor == autor.getIdAutor(); // o el campo identificador único
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAutor);
    }
}
