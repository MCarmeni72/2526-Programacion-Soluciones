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
        return " Curso: "+this.nombre+
                "\nEstudiantes: "+this.estudiantes;
    }

    public int numEstudiantes(){
        int contadorEstudiantes = 0;
        for(int i = 0; i < this.estudiantes.length; i++){
            if(this.estudiantes[i] != null){
                contadorEstudiantes++;
            }
        }
        return contadorEstudiantes;
    }

    //hacer un método que me añada un estudiante nuevo al array de estudiantes
    public boolean insertaEstudiante(Estudiante estudiante){
        boolean estaInsertado = false;
        if((estudiante !=null)&&(this.numEstudiantes()<30)&&!this.existeEstudiante(estudiante)){
            for(int i = 0; i < this.estudiantes.length&&!estaInsertado; i++){
                if(this.estudiantes[i]==null){
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
                if (this.estudiantes[i]!=null && this.estudiantes[i].equals(estudiante)) {
                    existe = true;
                }
            }

        return existe;
    }

    //escribir un método que reciba el dni de un estudiante, y me devuelva
    //el objeto estudiante completo correspondiente a ese dni
    // o me devuelva False porque no lo haya encontrado

}
