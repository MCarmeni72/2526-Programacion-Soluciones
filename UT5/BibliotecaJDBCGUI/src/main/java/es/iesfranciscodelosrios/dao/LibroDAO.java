package es.iesfranciscodelosrios.dao;

import es.iesfranciscodelosrios.dataaccess.ConnectionBD;
import es.iesfranciscodelosrios.model.Autor;
import es.iesfranciscodelosrios.model.Libro;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LibroDAO {
    private static final String SQL_FIND_ALL = "SELECT * FROM libro ORDER BY titulo";
    private static final String SQL_FIND_BY_ID = "SELECT * FROM libro WHERE idLibro = ?";
    private static final String SQL_FIND_BY_ISBN = "SELECT * FROM libro WHERE ISBN = ?";
    private static final String SQL_FIND_BY_ID_AUTOR = "SELECT * FROM libro WHERE idAutor = ? ORDER BY titulo";
    private static final String SQL_INSERT = "INSERT INTO libro (titulo, ISBN, idAutor) VALUES (?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE libro SET titulo = ?, ISBN = ?, idAutor = ? WHERE idLibro = ?";
    private static final String SQL_DELETE = "DELETE FROM libro WHERE idLibro = ?";

    private LibroDAO() {
    }

    public static List<Libro> findAll() {
        List<Libro> libros = new ArrayList<>();

        try (Statement st = ConnectionBD.getInstance().getConnection().createStatement();
             ResultSet rs = st.executeQuery(SQL_FIND_ALL)) {

            while (rs.next()) {
                libros.add(createLibroFromResultSet(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return libros;
    }

    public static Libro findById(int idLibro) throws SQLException {
        Libro libro = null;

        try (PreparedStatement ps = ConnectionBD.getInstance().getConnection().prepareStatement(SQL_FIND_BY_ID)) {
            ps.setInt(1, idLibro);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                libro = createLibroFromResultSet(rs);
            }
        }

        return libro;
    }

    public static Libro addLibro(Libro libro) throws SQLException {
        if (!isLibroValido(libro) || findByISBN(libro.getISBN()) != null) {
            return null;
        }

        try (PreparedStatement ps = ConnectionBD.getInstance().getConnection().prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, libro.getTitulo());
            ps.setString(2, libro.getISBN());
            ps.setInt(3, libro.getAutor().getIdAutor());
            ps.executeUpdate();

            ResultSet generatedKeys = ps.getGeneratedKeys();
            if (generatedKeys.next()) {
                libro.setIdLibro(generatedKeys.getInt(1));
            }
        }

        return libro;
    }

    public static boolean updateLibro(Libro libroNuevo) throws SQLException {
        if (!isLibroValido(libroNuevo)) {
            return false;
        }

        Libro libroActual = findById(libroNuevo.getIdLibro());
        if (libroActual == null) {
            return false;
        }

        Libro libroConMismoIsbn = findByISBN(libroNuevo.getISBN());
        if (libroConMismoIsbn != null && libroConMismoIsbn.getIdLibro() != libroNuevo.getIdLibro()) {
            return false;
        }

        try (PreparedStatement ps = ConnectionBD.getInstance().getConnection().prepareStatement(SQL_UPDATE)) {
            ps.setString(1, libroNuevo.getTitulo());
            ps.setString(2, libroNuevo.getISBN());
            ps.setInt(3, libroNuevo.getAutor().getIdAutor());
            ps.setInt(4, libroNuevo.getIdLibro());
            ps.executeUpdate();
            return true;
        }
    }

    public static boolean deleteLibroById(int idLibro) throws SQLException {
        if (findById(idLibro) == null) {
            return false;
        }

        try (PreparedStatement ps = ConnectionBD.getInstance().getConnection().prepareStatement(SQL_DELETE)) {
            ps.setInt(1, idLibro);
            ps.executeUpdate();
            return true;
        }
    }

    /**
     * Método que devuelve una lista con todos los libros de un autor especifico.
     */
    public static List<Libro> findByIdAutor(int idAutor) throws SQLException {
        ArrayList<Libro> libros = new ArrayList<>();

        try (PreparedStatement st = ConnectionBD.getInstance().getConnection().prepareStatement(SQL_FIND_BY_ID_AUTOR)) {
            st.setInt(1, idAutor);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("idLibro");
                String titulo = rs.getString("titulo");
                String isbn = rs.getString("ISBN");
                Autor autor = AutorDAO.findById(rs.getInt("idAutor"));
                Libro libro = new Libro(id, titulo, isbn, autor);
                libros.add(libro);
            }
        }
        return libros;
    }

    private static Libro findByISBN(String isbn) {
        Libro libro = null;

        try (PreparedStatement ps = ConnectionBD.getInstance().getConnection().prepareStatement(SQL_FIND_BY_ISBN)) {
            ps.setString(1, isbn);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                libro = createLibroFromResultSet(rs);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return libro;
    }

    private static boolean isLibroValido(Libro libro) {
        return libro != null
                && libro.getTitulo() != null && !libro.getTitulo().isBlank()
                && libro.getISBN() != null && !libro.getISBN().isBlank()
                && libro.getAutor() != null;
    }

    private static Libro createLibroFromResultSet(ResultSet rs) throws SQLException {
        int id = rs.getInt("idLibro");
        String titulo = rs.getString("titulo");
        String isbn = rs.getString("ISBN");
        Autor autor = AutorDAO.findById(rs.getInt("idAutor"));
        return new Libro(id, titulo, isbn, autor);
    }
}
