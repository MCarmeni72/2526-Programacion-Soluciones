package model;

//crud de curso: - añadir un estudiante sin repetidos (dos estudiante son iguales si tienen el mismo DNI)
//               - Obtener un estudiante por DNI
//               - Obtener un estudiante por el objeto
//               - Eliminar un estudiante por DNI
//               - Eliminar un estudiante por el objeto completo
//               - Obtener todos los estudiante
//               -

import java.util.ArrayList;
import java.util.List;

public class Curso {
    private String nombre;
    private List<Estudiante> misEstudiantes;

    public Curso (String nombre){
        this.nombre=nombre;
        this.misEstudiantes = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Estudiante> getMisEstudiantes (){
        return this.misEstudiantes;
    }

    //CRUD

    /*
    Añadir un estudiante
     */
    public boolean addEstudiante (Estudiante e){
        if(e==null) {
            return false;
        }

        if(!misEstudiantes.contains(e)){
            return misEstudiantes.add(e);
        }
        return false;
    }

    /**
     * Método que busca por el dni a un estudiante en la lista de estudiante
     * @param dni por el que buca
     * @return el objeto estudiante si lo ha encontrado, null si no existe un estudiante con ese dni
     */
    public Estudiante searchEstudiante(String dni){
        if(dni==null) return null;
        for (Estudiante e: misEstudiantes){
                if(e.getDni().equals(dni)) return e;

        }
        return null;
    }

    /**
     * Método que busca un estudiante en la lista de estudiantes
     * @param e objeto estudiante buscado
     * @return el objeto estudiante si lo ha encontrado, null si no existe un estudiante con ese dni
     */
    public Estudiante searchEstudiante(Estudiante e){
        if (misEstudiantes.contains(e)){
            return e;
        }
        return null;
    }

    public boolean removeEstudiante(String dni){
      /*  if (dni==null) return false;
        for (Estudiante e: misEstudiantes){
            if(e.getDni().equals(dni))    return misEstudiantes.remove(e);
        }
        return false;
      */
      Estudiante e = this.searchEstudiante(dni);
      if(e==null) return false;
      return misEstudiantes.remove(e);
    }












}
