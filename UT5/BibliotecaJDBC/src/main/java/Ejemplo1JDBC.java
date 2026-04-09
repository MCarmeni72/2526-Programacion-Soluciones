import model.Autor;
import model.Libro;

import java.sql.*;
import java.util.ArrayList;

public class Ejemplo1JDBC {
    static void main() {
        //1. Definir los datos de acceso a la bbdd.
        String user = "root";
        String password = "1234";
        String url = "jdbc:mysql://localhost:3307/biblioteca";

        String query = "SELECT * FROM libro";

        Libro libro = null;
        Autor autor = null;
        ArrayList<Libro> libros = new ArrayList<>();

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
                int idAutor = rs.getInt("idAutor");

                String query2 = "SELECT * FROM autor where idAutor ="+idAutor;

                Statement st2 = con.createStatement();
                ResultSet rs2 = st2.executeQuery(query2);
                if(rs2.next()) {
                    int idAutor2 = rs2.getInt("idAutor");
                    String nombreAutor = rs2.getString("nombre");
                    autor = new Autor(idAutor2, nombreAutor);
                }
                libro = new Libro(id,titulo,ISBN,autor);
                libros.add(libro);

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        for(Libro l : libros) {
            System.out.println(l);
        }

    }


}
