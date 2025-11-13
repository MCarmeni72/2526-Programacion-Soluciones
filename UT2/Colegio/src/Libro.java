/*
CREAR UNA CLASE LIBRO, DEL LIBRO NECESITO SABER SU TITULO, SU AUTOR, SU ISBN Y AÑO DE PUBLICACIÓN
CREA UN EJECUTABLE QUE ME PERMITA CREAR UN LIBRO SOLO CON SU ISBN RELLENO, Y LOS DEMÁS DATOS CON
SU VALOR POR DEFECTO.
eL EJECUTABLE TB DEBE PERMITIR CREAR UN LIBRO CON TODOS LOS DATOS RELLENOS, Y ADEMÁS DEBE PERMITIR
CREAR UN LIBRO SOLO CON ISBN Y TITULO.
CREA VARIOS LIBROS PARA PROBAR LAS DIFERENTES OPCIONES Y MUESTRALOS POR PANTALLA
 */

public class Libro {
    String titulo;
    String autor;
    String isbn;
    int yearPublished;

    public Libro(String isbn){
        this.isbn = isbn;
    }
    public Libro(String titulo, String autor, String isbn, int yearPublished){
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.yearPublished = yearPublished;
    }
    public Libro(String titulo, String isbn){
        this.titulo = titulo;
        this.isbn = isbn;
    }
    public String toString(){
        return "Titulo: "+this.titulo+
                "\nAutor: "+this.autor+
                "\nISBN: "+this.isbn+
                "\nYear Published: "+this.yearPublished;
    }
}
