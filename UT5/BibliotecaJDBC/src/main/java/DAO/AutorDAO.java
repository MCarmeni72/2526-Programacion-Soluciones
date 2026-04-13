package DAO;

import dataAccess.ConnectionBD;
import model.Autor;
import model.Libro;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AutorDAO {
    /**
     * Versión Lazy del Método que devuelve una lista con todos los autores almacenados en la tabla autor de la bbdd biblioteca,
     * no obtengo la lista de libros de cada autor
     *
     * @return lista con todos los autores
     */
    public static List<Autor> findAll() {
        //1. Definir los datos de acceso a la bbdd.

        //2. Establecer la consulta en un string
        String query = "SELECT * FROM autor";

        Autor autor = null;
        List<Autor> autores = new ArrayList<>();
        //3. Establecer la conexión con la base de datos
        Connection con;
        try {
            con = ConnectionBD.getConnection();
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
     * Versión EAGER del Método que devuelve una lista con todos los autores almacenados en la tabla autor de la bbdd biblioteca,
     * * SI obtengo la lista de libros de cada autor
     * * @return lista con todos los autores
     */

    public static List<Autor> findAllEager() {
        //1. Definir los datos de acceso a la bbdd.

        //2. Establecer la consulta en un string
        String query = "SELECT * FROM autor";

        Autor autor = null;
        List<Autor> autores = new ArrayList<>();
        //3. Establecer la conexión con la base de datos
        Connection con;
        try {
            con = ConnectionBD.getConnection();
            //4. Crear un objeto Statement
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                int idAutor = rs.getInt("idAutor");
                String nombreAutor = rs.getString("nombre");
                List<Libro> libros = LibroDAO.findByIdAutor(idAutor);
                autor = new Autor(idAutor, nombreAutor, libros);
                // tengo que buscar la lista de libros de cada autor,
                autores.add(autor);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return autores;
    }


 /*
 //este código permite inyección de código, permitiendo que quien lo use pueda en idAutor meter valores que rompan la BBDD

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
    }*/

    /**
     * Método que devuelve un objeto Autor por su id, en versión Lazy, ya que no estamos rellanado la lista de libros de ese autor
     *
     * @param idAutor id del autor
     * @return devuel el objeto de tipo Autor con el id del autor, y el nombre del autor, si lo ha encontrado en la bbdd, sino devuelve NULL
     */
    public static Autor findById(int idAutor) {
        Autor autor = null;


        //Así no es la forma mas correcta porque permite inyeccion de código
        // String sql = "SELECT * FROM autor WHERE idAutor = "+idAutor;
        //LA FORMA CORRECTA ES CON SENTANCIAS PREPARADAS, donde la ? representa al parámetro
        String query2 = "SELECT * FROM autor where idAutor =?";
        Connection con;
        try {
            con = ConnectionBD.getConnection();
            //aqui viene el cambio cuando usamos parámetros. Ahora vamos a usar una clase
            //que me permite darle un valor a las ? (parámetros), esa clase se llama PreparedStatement
            PreparedStatement ps = con.prepareStatement(query2);
            ps.setInt(1, idAutor);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int idAutor2 = rs.getInt("idAutor");
                String nombreAutor = rs.getString("nombre");
                //esta linea siguiente sacará la lista de libros de ese autor, version EAGER
                // List<Libro> libros = LibroDAO.findByIdAutor(idAutor);
                // autor = new Autor(idAutor2, nombreAutor,libros);
                autor = new Autor(idAutor2, nombreAutor);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return autor;

    }

    /**
     * Método que devuelve un objeto Autor por su id, en versión Eager,es decir, la lista de libros de ese autor se obtiene en la misma consulta
     *
     * @param idAutor id del autor
     * @return devuel el objeto de tipo Autor con el id del autor, y el nombre del autor, si lo ha encontrado en la bbdd, sino devuelve NULL
     */
    public static Autor findByIdEager(int idAutor) {
        Autor autor = null;

        //Así no es la forma mas correcta porque permite inyeccion de código
        // String sql = "SELECT * FROM autor WHERE idAutor = "+idAutor;
        //LA FORMA CORRECTA ES CON SENTANCIAS PREPARADAS, donde la ? representa al parámetro
        String query2 = "SELECT * FROM autor where idAutor =?";
        Connection con;
        try {
            con = ConnectionBD.getConnection();
            //aqui viene el cambio cuando usamos parámetros. Ahora vamos a usar una clase
            //que me permite darle un valor a las ? (parámetros), esa clase se llama PreparedStatement
            PreparedStatement ps = con.prepareStatement(query2);
            ps.setInt(1, idAutor);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int idAutor2 = rs.getInt("idAutor");
                String nombreAutor = rs.getString("nombre");
                //esta linea siguiente sacará la lista de libros de ese autor, version EAGER
                List<Libro> libros = LibroDAO.findByIdAutor(idAutor);
                autor = new Autor(idAutor2, nombreAutor, libros);

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return autor;

    }


}
