public class Ejecutable {
    public static void main(String[] args) {
       Estudiante e1 = new Estudiante("12345678R","Juan","957","j@j.es");
       Estudiante e2 = new Estudiante("22222222X","Antonio","957","j@j.es");
       Estudiante e3 = new Estudiante("11111111W","Andrea","478","andrea@a.es");
       Estudiante e4 = new Estudiante("98765432D","Luis","478","luis@a.es");

       Estudiante e5 = new Estudiante("47112312Q","Maria","1547","maria@a.es");

       Estudiante e6 = null;

       Estudiante estudianteBuscado = null;

      // Estudiante [] arrayEstudiantes = {e1,e2,e3,e4};

        Curso curso1 = new Curso("1DAM",30);
        //curso1.setEstudiantes(arrayEstudiantes);


        if(curso1.insertaEstudiante(e1)){
            System.out.println("El alumno "+e1.getNombre()+" ha sido insertado exitosamente");
        }else{
            System.out.println("El alumno "+e1.getNombre()+" No se ha insertardo");
        }

        if(curso1.insertaEstudiante(e2)){
            System.out.println("El alumno "+e2.getNombre()+" ha sido insertado exitosamente");
        }else{
            System.out.println("El alumno "+e2.getNombre()+" No se ha insertardo");
        }

        if(curso1.insertaEstudiante(e6)){
            System.out.println("El alumno  ha sido insertado exitosamente");
        }else{
            System.out.println("El alumno  No se ha insertardo");
        }

        estudianteBuscado = (curso1.obtenerEstudiantePorDNI("22222222X"));
        if (estudianteBuscado != null) {
            System.out.println("El estudiante buscado es " + estudianteBuscado.getNombre());
        } else {
            System.out.println("El estudiante buscado no existe");
        }

        estudianteBuscado = curso1.obtenerEstudiantePorDNI("77777777S");
        if (estudianteBuscado != null) {
            System.out.println("El estudiante buscado es " + estudianteBuscado.getNombre());
        } else {
            System.out.println("El estudiante buscado no existe");
        }




  }
}
