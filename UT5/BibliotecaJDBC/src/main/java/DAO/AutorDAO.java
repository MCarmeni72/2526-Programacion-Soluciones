package DAO;

import model.Autor;
import model.Libro;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AutorDAO {
    /**
     * Versión Lazy del Método que devuelve una lista con todos los autores almacenados en la tabla autor de la bbdd biblioteca,
     * no obtengo la lista de libros de cada autor
     * @return lista con todos los autores
     */
    public static List<Autor> findAll() {
        //1. Definir los datos de acceso a la bbdd.
        String user = "root";
        String password = "1234";
        String url = "jdbc:mysql://localhost:3307/biblioteca";

        //2. Establecer la consulta en un string
        String query = "SELECT * FROM autor";

        Autor autor = null;
        List<Autor> autores = new ArrayList<>();
        //3. Establecer la conexión con la base de datos
        Connection con;
        try {
            con = DriverManager.getConnection(url, user, password);
            //4. Crear un objeto Statement
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                int idAutor = rs.getInt("idAutor");
                String nombreAutor = rs.getString("nombre");
                autor = new Autor(idAutor, nombreAutor);
                autores.add(autor);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return autores;
    }

    /**
     *Versión EAGER del Método que devuelve una lista con todos los autores almacenados en la tabla autor de la bbdd biblioteca,
     *      * SI obtengo la lista de libros de cada autor
     *      * @return lista con todos los autores
     */

    public static List<Autor> findAllEager() {
        //1. Definir los datos de acceso a la bbdd.
        String user = "root";
        String password = "1234";
        String url = "jdbc:mysql://localhost:3307/biblioteca";

        //2. Establecer la consulta en un string
        String query = "SELECT * FROM autor";

        Autor autor = null;
        List<Autor> autores = new ArrayList<>();
        //3. Establecer la conexión con la base de datos
        Connection con;
        try {
            con = DriverManager.getConnection(url, user, password);
            //4. Crear un objeto Statement
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                int idAutor = rs.getInt("idAutor");
                String nombreAutor = rs.getString("nombre");
                List<Libro> libros = LibroDAO.findByIdAutor(idAutor);
                autor = new Autor(idAutor, nombreAutor,libros);
                // tengo que buscar la lista de libros de cada autor,
                autores.add(autor);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return autores;
    }


    public static Autor findById(int idAutor){
        String user = "root";
        String password = "1234";
        String url = "jdbc:mysql://localhost:3307/biblioteca";

        String query2 = "SELECT * FROM autor where idAutor ="+idAutor;
        Connection con;
        Autor autor = null;
        try {
            con = DriverManager.getConnection(url, user, password);
            Statement st2 = con.createStatement();
            ResultSet rs2 = st2.executeQuery(query2);
            if(rs2.next()) {
                int idAutor2 = rs2.getInt("idAutor");
                String nombreAutor = rs2.getString("nombre");
                autor = new Autor(idAutor2, nombreAutor);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return autor;
    }

}
