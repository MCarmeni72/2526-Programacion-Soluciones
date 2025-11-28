public class Curso {
    private String nombre;
    private Estudiante[] estudiantes;

    public Curso(String nombre, int cantidadEstudiantes) {
        this.nombre = nombre;
        this.estudiantes = new Estudiante[cantidadEstudiantes];
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Estudiante[] getEstudiantes() {
        return this.estudiantes;
    }

    public void setEstudiantes(Estudiante[] estudiantes) {
        this.estudiantes = estudiantes;
    }

    public String toString() {
        return " Curso: " + this.nombre +
                "\nEstudiantes: " + this.estudiantes;
    }

    public int numEstudiantes() {
        int contadorEstudiantes = 0;
        for (int i = 0; i < this.estudiantes.length; i++) {
            if (this.estudiantes[i] != null) {
                contadorEstudiantes++;
            }
        }
        return contadorEstudiantes;
    }

    //hacer un método que me añada un estudiante nuevo al array de estudiantes
    public boolean insertaEstudiante(Estudiante estudiante) {
        boolean estaInsertado = false;
        if ((estudiante != null) && (this.numEstudiantes() < 30) && !this.existeEstudiante(estudiante)) {
            for (int i = 0; i < this.estudiantes.length && !estaInsertado; i++) {
                if (this.estudiantes[i] == null) {
                    this.estudiantes[i] = estudiante;
                    estaInsertado = true;
                    System.out.println("hola");
                }
            }
        }

        return estaInsertado;
    }

    private boolean existeEstudiante(Estudiante estudiante) {
        boolean existe = false;

        for (int i = 0; i < this.estudiantes.length && !existe; i++) {
            if (this.estudiantes[i] != null && this.estudiantes[i].equals(estudiante)) {
                existe = true;
            }
        }

        return existe;
    }

    /**
     * Busca un estudiante en la clase a partir de su DNI
     * @param dniBuscado DNI del estudiante
     * @return Estudiante buscado o null si no existe
     */
    public Estudiante obtenerEstudiantePorDNI(String dniBuscado) {
        Estudiante estudianteBuscado = null;

        for (int i = 0; i < this.estudiantes.length && estudianteBuscado == null; i++) {
            if (this.estudiantes[i] != null && this.estudiantes[i].getDni().equals(dniBuscado)) {
                estudianteBuscado = this.estudiantes[i];
            }
        }

        return estudianteBuscado;
    }

}
