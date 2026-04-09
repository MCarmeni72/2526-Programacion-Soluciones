package DAO;

import model.Autor;
import model.Libro;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LibroDAO {
    public static List<Libro> findByIdAutor(int idAutor) {
        //1. Definir los datos de acceso a la bbdd.
        String user = "root";
        String password = "1234";
        String url = "jdbc:mysql://localhost:3307/biblioteca";

        ArrayList<Libro> libros = new ArrayList<>();

        //2. Establecer la consulta en un string
        String query = "SELECT * FROM libro Where idAutor =" + idAutor;
        //2. Establecer la conexión con la base de datos
        Connection con;
        try {
            con = DriverManager.getConnection(url, user, password);
            //3. Crear un objeto Statement
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            //4. recorrer el resultado, next() devuelve true si hay registro, false si no.
            while (rs.next()) {
                //  System.out.println(rs.getInt(1));
                int id = rs.getInt("idLibro");
                String titulo = rs.getString("titulo");
                String ISBN = rs.getString("ISBN");
                //Autor autor = AutorDAO.findById(rs.getInt("idAutor"));
                Libro libro = new Libro(id,titulo,ISBN);
                libros.add(libro);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return libros;
    }
}
