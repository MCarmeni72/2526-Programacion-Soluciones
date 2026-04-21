package DAO;

import dataAccess.ConnectionBD;
import model.Autor;
import model.Libro;

import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LibroDAO {
    private final static String SQL_ALL = "SELECT * FROM libro";
    private final static String SQL_FIND_BY_ID_AUTOR = "SELECT * FROM libro Where idAutor = ?";
    private final static String SQL_FIND_BY_ID = "SELECT * FROM libro where idLibro =?";
    private final static String SQL_FIND_BY_TITULO = "SELECT * FROM libro where titulo =?";
    private final static String SQL_FIND_BY_CONTAIN_TITULO = "SELECT * FROM libro WHERE titulo LIKE ?";
    private final static String SQL_INSERT = "INSERT INTO libro (titulo, ISBN, idAutor) VALUES (?,?,?)";



    /**
     * Metodo que me devuelve una lista con todos los libros de la bbdd (versión Lazy, es decir, no estamos rellenando la lista de autores de cada libro)
     *
     * @return lista con todos los libros de la bbdd (o una lista vacia si no hay libros)
     */
    public static List<Libro> findAll() {
        List<Libro> libros = new ArrayList<>();
        try (ResultSet rs = ConnectionBD.getConnection().createStatement().executeQuery(SQL_ALL)) {
            while (rs.next()) {
                int id = rs.getInt("idLibro");
                String titulo = rs.getString("titulo");
                String ISBN = rs.getString("ISBN");
                Libro libro = new Libro(id, titulo, ISBN);
                libros.add(libro);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return libros;
    }

    /**
     * Metodo que me devuelve una lista con todos los libros de la bbdd (versión eager, es decir, SI estamos rellenando el autor de cada libro)
     *
     * @return lista con todos los libros de la bbdd (o una lista vacia si no hay libros)
     */
    public static List<Libro> findAllEager() {
        List<Libro> libros = new ArrayList<>();
        try (ResultSet rs = ConnectionBD.getConnection().createStatement().executeQuery(SQL_ALL)) {
            while (rs.next()) {
                int id = rs.getInt("idLibro");
                String titulo = rs.getString("titulo");
                String ISBN = rs.getString("ISBN");
                Autor autor = AutorDAO.findById(rs.getInt("idAutor"));
                Libro libro = new Libro(id, titulo, ISBN, autor);
                libros.add(libro);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return libros;
    }

    /**
     * Metodo que devuelve un objeto Libro por su id, en versión Lazy, ya que no estamos rellenando el autor de ese libro
     * @param idLibro
     * @return el objeto Libro con el id y el titulo del libro, si lo ha encontrado en la bbdd, sino devuelve NULL
     */
    public static Libro findById(int idLibro) {
        Libro libro = null;
        try(PreparedStatement ps = ConnectionBD.getConnection().prepareStatement(SQL_FIND_BY_ID)){
            ps.setInt(1, idLibro);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                int id = rs.getInt("idLibro");
                String titulo = rs.getString("titulo");
                String ISBN = rs.getString("ISBN");
               // Autor autor = AutorDAO.findById(rs.getInt("idAutor"));
                libro = new Libro(id, titulo, ISBN);
            }

        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return libro;
    }

    /**
     * Metodo que devuelve un objeto Libro por su id, en versión Eager, ya que SI estamos rellenando el autor de ese libro
     * @param idLibro
     * @return el objeto Libro con el id y el titulo del libro, si lo ha encontrado en la bbdd, sino devuelve NULL
     */
    public static Libro findByIdEager(int idLibro) {
        Libro libro = null;
        Libro libro2 = null;
        try(PreparedStatement ps = ConnectionBD.getConnection().prepareStatement(SQL_FIND_BY_ID)){
            ps.setInt(1, idLibro);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                int id = rs.getInt("idLibro");
                String titulo = rs.getString("titulo");
                String ISBN = rs.getString("ISBN");
                Autor autor = AutorDAO.findById(rs.getInt("idAutor"));
                libro = new Libro(id, titulo, ISBN,autor);
            }

        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return libro;
    }

    /**
     * Método que devuelve una lista con todos los libros de un autor especifico
     *
     * @param idAutor id del autor
     * @return lista con todos los libros del autor (o una lista vacía si no hay libros del autor)
     */
    public static List<Libro> findByIdAutor(int idAutor) {
        ArrayList<Libro> libros = new ArrayList<>();
        try (PreparedStatement ps = ConnectionBD.getConnection().prepareStatement(SQL_FIND_BY_ID_AUTOR)) {
            ps.setInt(1, idAutor);
            ResultSet rs = ps.executeQuery();

            //4. recorrer el resultado, next() devuelve true si hay registro, false si no.
            while (rs.next()) {
                int id = rs.getInt("idLibro");
                String titulo = rs.getString("titulo");
                String ISBN = rs.getString("ISBN");
                Autor autor = AutorDAO.findById(rs.getInt("idAutor"));
                Libro libro = new Libro(id, titulo, ISBN, autor);
                libros.add(libro);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return libros;
    }

    /**
     * Busca un libro por su titulo, devuelve una lista con los libros que coinciden con el titulo
     * @param titulo  titulo del libro buscado
     * @return lista con los libros que coinciden con el titulo, o una lista vacía si no hay coincidencias
     */
    public static List<Libro> findByTitulo(String titulo) {
        ArrayList<Libro> libros = new ArrayList<>();
        try (PreparedStatement ps = ConnectionBD.getConnection().prepareStatement(SQL_FIND_BY_TITULO)) {
            ps.setString(1, titulo);
            ResultSet rs = ps.executeQuery();

            //4. recorrer el resultado, next() devuelve true si hay registro, false si no.
            while (rs.next()) {
                int id = rs.getInt("idLibro");
                String tituloLeido = rs.getString("titulo");
                String ISBN = rs.getString("ISBN");
               // Autor autor = AutorDAO.findById(rs.getInt("idAutor"));
                Libro libro = new Libro(id, tituloLeido, ISBN);
                libros.add(libro);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return libros;
    }

    /**
     * Busca un libro QUE CONTENGA PARTE DEL TITULO
     * @param titulo  TEXTO CON PARTE DEL titulo del libro buscado
     * @return lista con los libros que coinciden con EL TEXTO BUSCADO, o una lista vacía si no hay coincidencias
     */
    public static List<Libro> findByContainTitulo(String titulo) {
        ArrayList<Libro> libros = new ArrayList<>();
        try (PreparedStatement ps = ConnectionBD.getConnection().prepareStatement(SQL_FIND_BY_CONTAIN_TITULO)) {

            ps.setString(1, "%"+titulo+"%");
            ResultSet rs = ps.executeQuery();

            //4. recorrer el resultado, next() devuelve true si hay registro, false si no.
            while (rs.next()) {
                int id = rs.getInt("idLibro");
                String tituloLeido = rs.getString("titulo");
                String ISBN = rs.getString("ISBN");
                // Autor autor = AutorDAO.findById(rs.getInt("idAutor"));
                Libro libro = new Libro(id, tituloLeido, ISBN);
                libros.add(libro);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return libros;
    }

    public static boolean addLibro(Libro l){
        boolean added = false;
        if((l != null) && findById(l.getIdLibro()) == null){
            try(PreparedStatement ps = ConnectionBD.getConnection().prepareStatement(SQL_INSERT)){
                ps.setString(1, l.getTitulo());
                ps.setString(2, l.getISBN());
                ps.setInt(3, l.getAutor().getIdAutor());
                ps.executeUpdate();
                added = true;
            }catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return added;
    }
}
