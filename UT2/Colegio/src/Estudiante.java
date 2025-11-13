public class Estudiante {
    String dni;
    String nombre;
    String tlf;
    String email;

    public Estudiante() {
        nombre = "";
        dni = "";
        tlf = "";
        email = "";
    }

    public Estudiante(String dni){
        this.dni = dni;
        this.nombre = "-";
        this.tlf = "";
        this.email = "";
    }

    public Estudiante(String dni, String nombre, String tlf, String email) {
        this.dni = dni;
        this.nombre = nombre;
        this.tlf = tlf;
        this.email = email;
    }



    public String toString(){
        return "Nombre: "+nombre+
                "\nDNI: "+dni+
                "\nTlf: "+tlf+
                "\nEmail: "+email;
    }
}
