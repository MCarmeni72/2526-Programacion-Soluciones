package es.iesfranciscodelosrios.dao;

import es.iesfranciscodelosrios.dataaccess.ConnectionBD;
import es.iesfranciscodelosrios.model.Autor;
import es.iesfranciscodelosrios.model.Libro;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LibroDAO {
    /**
     * Método que devuelve una lista con todos los libros de un autor especifico
     *
     * @param idAutor id del autor
     * @return lista con todos los libros del autor (o una lista vacía si no hay libros del autor)
     */
    public static List<Libro> findByIdAutor(int idAutor) {
        ArrayList<Libro> libros = new ArrayList<>();

        //2. Establecer la consulta en un string
        String query = "SELECT * FROM libro Where idAutor = ?";
        Connection con;
        try {
            con = ConnectionBD.getConnection();
            //3. Crear un objeto Statement
            PreparedStatement st = con.prepareStatement(query);
            st.setInt(1, idAutor);
            ResultSet rs = st.executeQuery();

            //4. recorrer el resultado, next() devuelve true si hay registro, false si no.
            while (rs.next()) {
                //  System.out.println(rs.getInt(1));
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
}
