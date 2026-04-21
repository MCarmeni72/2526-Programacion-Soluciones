import DAO.AutorDAO;
import DAO.LibroDAO;
import model.Autor;
import model.Libro;

import java.util.ArrayList;
import java.util.List;

public class Ejemplo3PruebaLibros {
    static void main() {
       /* List<Libro> libros = LibroDAO.findAllEager();
        for(Libro l : libros) {
            System.out.println(l);
        }*/

       /* Libro l = LibroDAO.findByIdEager(3);
        if (l != null)
            System.out.println(l);
        else
            System.out.println("no existe");

        */

      /*  List <Libro> libros = LibroDAO.findByContainTitulo("Harry Potter");
        for(Libro l : libros) {
            System.out.println(l);
        }*/
        Autor autor = AutorDAO.findById(2);
        Libro l = new Libro ("Harry Potter y el cáliz de fuego","147153369",autor);
        if(LibroDAO.addLibro(l)){
            System.out.println("se agrego correctamente");
        }else {
            System.out.println("no se agrego");
        }

    }
}
