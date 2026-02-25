package controller;

import model.Curso;
import model.Estudiante;
import view.CursoVista;

import java.util.ArrayList;
import java.util.List;

public class CursoControlador {
    private Curso miCurso;

    public CursoControlador(Curso miCurso) {
        this.miCurso = miCurso;
    }

    public void iniciar() {
        int opcion;
        do {
            CursoVista.muestraMenu(miCurso.getNombre());
            opcion = CursoVista.leeEntero("Introduce Opcion: ");

            switch (opcion) {
                case 1 -> addEstudiante();
                case 2 -> buscarPorDni();
                case 3 -> eliminarPorDni();
                case 4 -> listar();
                case 0 -> CursoVista.muestraMensaje("Saliendo ... ");
                default -> CursoVista.muestraMensaje("Opción no válida");
            }
        } while (opcion != 0);
    }



    private void addEstudiante() {
        String dni = CursoVista.leeCadena("DNI: ");
        String nombre = CursoVista.leeCadena("Nombre: ");
        String teleno = CursoVista.leeCadena("Telefono: ");
        String email = CursoVista.leeCadena("e-mail: ");

        Estudiante e = new Estudiante(dni,nombre,teleno,email);
        if(miCurso.addEstudiante(e)){
            CursoVista.muestraMensaje("Estudiante insertado correctamente");
        }else{
            CursoVista.muestraMensaje("No se ha podido añadir (DNI duplicado o datos no validos");
        }
    }

    private void buscarPorDni() {
        String dni = CursoVista.leeCadena("Introduce DNI a buscar: ");
        Estudiante e = miCurso.searchEstudiante(dni);
        if(e==null){
            CursoVista.muestraMensaje("No existe el estudiante con el dni: "+dni);
        }else{
            CursoVista.muestraMensaje(e.toString());
        }
    }

    private void eliminarPorDni() {
        String dni = CursoVista.leeCadena("Introduce DNI a buscar: ");
        if(miCurso.removeEstudiante(dni)){
            CursoVista.muestraMensaje("Estudiante eliminado");
        }else{
            CursoVista.muestraMensaje("No existe el estudiante con el dni: "+dni);
        }

    }


    private void listar() {
        List<String> lineas = new ArrayList<>();
        for(Estudiante e: miCurso.getMisEstudiantes()){
            lineas.add(e.toString());
        }
        CursoVista.muestraListado(lineas);


    }





}
