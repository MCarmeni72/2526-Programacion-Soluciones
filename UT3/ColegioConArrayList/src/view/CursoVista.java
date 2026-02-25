package view;

import java.sql.SQLOutput;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class CursoVista {


    public static int leeEntero(String msn) {
        Scanner sc = new Scanner(System.in);
        int n = 0;
        boolean error = false;
        do {
            try {
                System.out.println(msn);
                n = sc.nextInt();
                error = false;
            } catch (InputMismatchException e) {
                System.out.println("Valor no válido");
                error = true;
                sc.next();
            }
        } while (error);
        return n;
    }

    public static String leeCadena(String msn){
        Scanner sc = new Scanner(System.in);
        boolean leido =false;
        String s = null;
        while(!leido){
            s=sc.nextLine();
            if(s.isEmpty()){
                System.out.println("ERROR: la cadena no puede estar vacía");
            }else{
                leido = true;
            }
        }
        return s;
    }

    public static void muestraMenu(String nombreCurso){
        System.out.println( "\n ---  Curso: "+ nombreCurso+"  ---");
        System.out.println("1. Añadir estudiante");
        System.out.println("2. Buscar por DNI");
        System.out.println("3. Eliminar por DNI");
        System.out.println("4. Listar todos los estudiantes");
        System.out.println("0. Salir");

    }

    public void muestraMensaje (String msn){
        System.out.println(msn);
    }

    public void muestraListado(List<String> lineas){
      if(lineas == null || lineas.isEmpty()){
          System.out.println("No hay elementos");
      }else{
          for(String linea: lineas){
              System.out.println(" -------------- ");
              System.out.println(linea);
          }
      }
    }

}
