package model;

public class Libro {
    private int idLibro;
    private String titulo;
    private String ISBN;
    private Autor autor;
    public Libro(int idLibro, String titulo, String ISBN, Autor autor) {
        this.idLibro = idLibro;
        this.titulo = titulo;
        this.ISBN = ISBN;
        this.autor = autor;
    }
    public Libro(int idLibro, String titulo, String ISBN) {
        this.idLibro = idLibro;
        this.titulo = titulo;
        this.ISBN = ISBN;
    }
    public Libro(String titulo, String ISBN, Autor autor) {
        this.titulo = titulo;
        this.ISBN = ISBN;
        this.autor = autor;
    }
    public int getIdLibro() {
        return idLibro;
    }
    public String getTitulo() {
        return titulo;
    }
    public String getISBN() {
        return ISBN;
    }
    public Autor getAutor() {return autor; }
    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }
    public void setAutor(Autor autor) {this.autor = autor; }
    @Override
    public String toString() {
        return "Libro{" + "idLibro=" + idLibro + ", titulo=" + titulo + ", ISBN=" + ISBN + ", autor=" + autor + '}';
    }
}
