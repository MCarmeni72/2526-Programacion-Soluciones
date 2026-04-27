package es.iesfranciscodelosrios.dao;

import es.iesfranciscodelosrios.dataaccess.ConnectionBD;
import es.iesfranciscodelosrios.model.Autor;
import es.iesfranciscodelosrios.model.Libro;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AutorDAO {
    private final static String SQL_ALL = "SELECT * FROM autor";
    private final static String SQL_FIND_BY_ID = "SELECT * FROM autor where idAutor =?";
    private final static String SQL_FIND_BY_NAME = "SELECT * FROM autor where nombre =?";
    private final static String SQL_INSERT = "INSERT INTO autor (nombre) VALUES (?)";
    private final static String SQL_UPDATE = "UPDATE autor SET nombre = ? WHERE idAutor = ?";
    private final static String SQL_DELETE = "DELETE FROM autor WHERE idAutor = ?";

    /**
     * Versión Lazy del Método que devuelve una lista con todos los autores almacenados en la tabla autor de la bbdd biblioteca,
     * no obtengo la lista de libros de cada autor
     *
     * @return lista con todos los autores
     */
    public static List<Autor> findAll() {
        Autor autor = null;
        List<Autor> autores = new ArrayList<>();
        Connection con;
        try {
            con = ConnectionBD.getConnection();
            //4. Crear un objeto Statement
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(SQL_ALL);
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
        Autor autor = null;
        List<Autor> autores = new ArrayList<>();
        //3. Establecer la conexión con la base de datos
        Connection con;
        try {
            con = ConnectionBD.getConnection();
            //4. Crear un objeto Statement
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(SQL_ALL);
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


    /**
     * Método que devuelve un objeto Autor por su id, en versión Lazy, ya que no estamos rellanado la lista de libros de ese autor
     *
     * @param idAutor id del autor
     * @return devuel el objeto de tipo Autor con el id del autor, y el nombre del autor, si lo ha encontrado en la bbdd, sino devuelve NULL
     */
    public static Autor findById(int idAutor) {
        Autor autor = null;
        try (PreparedStatement ps = ConnectionBD.getConnection().prepareStatement(SQL_FIND_BY_ID)) {
            ps.setInt(1, idAutor);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int idAutor2 = rs.getInt("idAutor");
                String nombreAutor = rs.getString("nombre");
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
        try (PreparedStatement ps = ConnectionBD.getConnection().prepareStatement(SQL_FIND_BY_ID)) {
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

    /**
     * Método que inserta un autor en la tabla autor de la bbdd biblioteca
     *
     * @param autor objeto de clase Autor, que tiene los datos de un autor concreto
     * @return el autor insertado o null si no hay podido insertarlo (está repetido o no tiene datos correctos)
     */
    public static Autor addAutor(Autor autor) {

        if ((autor != null) && findByName(autor.getNombre()) == null) {
            try (PreparedStatement ps = ConnectionBD.getConnection().prepareStatement(SQL_INSERT)) {
                ps.setString(1, autor.getNombre());
                ps.executeUpdate();
                //con la siguiente linea, una vez insertado, busco el autor por su nombre para devolverlo
                //con el id correcto que tiene en la bbdd
                autor=findByName(autor.getNombre());
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } else {
            autor = null;
        }
        return autor;
    }

    //otra posibilidad valida de añadir, devolviendo un boolean que me indique si se puede añadir o no
    public static boolean addAutor1(Autor autor) {
        boolean added = false;
        if ((autor != null) && findByName(autor.getNombre()) == null) {
            try (PreparedStatement ps = ConnectionBD.getConnection().prepareStatement(SQL_INSERT)) {
                ps.setString(1, autor.getNombre());
                ps.executeUpdate();
                added = true;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return added;
    }

    /**
     * Método que devuelve un objeto autor si lo ha encontrado en la tabla autor de la bbdd, en función de su nombre
     *
     * @param nombre cadena que contine el nombre del autor para buscar por él en la BBDD
     * @return objeto autor si lo ha encontrado, null si no existe el autor con ese nombre en la tabla de la bbdd
     */
    private static Autor findByName(String nombre) {
        Autor autor = null;
       /* Connection con;
        try {
            con = ConnectionBD.getConnection();
            PreparedStatement ps = con.prepareStatement(SQL_FIND_BY_NAME);*/
        try (PreparedStatement ps = ConnectionBD.getConnection().prepareStatement(SQL_FIND_BY_NAME)) {
            ps.setString(1, nombre);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int idAutor2 = rs.getInt("idAutor");
                String nombreAutor = rs.getString("nombre");
                autor = new Autor(idAutor2, nombreAutor);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return autor;
    }

    /**
     * Método que modifica el nombre de un autor si existe en la  bbdd
     * @param autorNuevo: objeto con los datos del nuevo autor
     * @param autorActual objeto con los datos del autor que se supone ya está en la bbdd
     * @return true si ha encontrado el autor por su nombre y lo ha modificado, false si no se ha podido modificar
     */
    public static boolean updateAutor(Autor autorNuevo, Autor autorActual){
        boolean updated = false;
        if((autorActual!=null)&&(autorNuevo!=null)&&findByName(autorActual.getNombre())!=null && findByName(autorNuevo.getNombre())==null){
            try (PreparedStatement ps = ConnectionBD.getConnection().prepareStatement(SQL_UPDATE)) {
                ps.setString(1, autorNuevo.getNombre());
                ps.setInt(2, autorActual.getIdAutor());
                ps.executeUpdate();
                updated = true;

            }catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return updated;
    }
    /**
     * Método que elimina un autor de la base de datos si existe, buscándolo por su ID.
     * @param idAutor:  el ID del autor a eliminar
     * @return true si ha encontrado y eliminado correctamente el autor, false si no se ha podido eliminar
     */
    public static boolean deleteAutorById(int idAutor) {
        boolean deleted = false;
        if(findById(idAutor)!=null){
            try (PreparedStatement ps = ConnectionBD.getConnection().prepareStatement(SQL_DELETE)) {
                ps.setInt(1, idAutor);
                ps.executeUpdate();
                deleted = true;
            }catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return deleted;
    }


}
