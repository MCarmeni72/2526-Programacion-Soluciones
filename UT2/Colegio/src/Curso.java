public class Curso {
    private String nombre;
    private Estudiante [] estudiantes;

    public Curso(String nombre, int cantidadEstudiantes){
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
    public String toString(){
        return this.nombre;
    }
}
