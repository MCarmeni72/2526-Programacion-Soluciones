import DAO.AutorDAO;
import DAO.LibroDAO;
import model.Autor;
import model.Libro;

import java.util.List;

//en este ejemplo vamos a ir probando los métodos de los DAO
public class Ejemplo2JDBC {
    static void main() {
        //probamos findAll de AutorDAO
      /*  List<Autor> autores = AutorDAO.findAll();

        for (Autor autor : autores) {
            System.out.println(autor);
        }*/

        //probamos findById de AutorDAO
       /* Autor autor = AutorDAO.findById(1);
        System.out.println(autor);
        Autor autor2 = AutorDAO.findById(3);
        if(autor2!=null)
            System.out.println(autor2);
        else
            System.out.println("no existe");

        */

        //probar findByIdAutor de LibroDAO, sacar una lista de libros por autor
       List<Libro> libros = LibroDAO.findByIdAutor(1);
        for(Libro l : libros) {
            System.out.println(l);
        }


        //probar findById del autor
      //  Autor autor = AutorDAO.findById(5);
      //  System.out.println(autor);
    }
}
