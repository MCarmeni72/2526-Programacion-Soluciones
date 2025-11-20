public class Estudiante {
    private String dni;
    private String nombre;
    private String tlf;
    private String email;



    public Estudiante(String dni) {
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

    public String getDni() {
        return this.dni;
    }

    public void setDni(String dni) {
        if(validaDni(dni)) {
            this.dni = dni;
        }
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTlf() {
        return this.tlf;
    }

    public void setTlf(String tlf) {
        this.tlf = tlf;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String toString() {
        return "Nombre: " + this.nombre +
                "\nDNI: " + this.dni +
                "\nTlf: " + this.tlf +
                "\nEmail: " + this.email;
    }

    @Override
    public boolean equals(Object obj) {
        boolean esIgual = false;
        if(this == obj) {
            esIgual = true;
        }else if((obj!=null)&&(obj.getClass().equals(Estudiante.class))) {
            Estudiante estudiante = (Estudiante) obj;
            if (this.dni.equals(estudiante.getDni())) {
                esIgual = true;
            }
        }
        return esIgual;
    }

    private boolean validaDni(String dni) {
        boolean valido = false;
        if(dni.length() == 9) {
            valido = true;
        }
        return valido;
    }
}
