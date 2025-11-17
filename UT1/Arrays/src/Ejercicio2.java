import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Hacer el ejercicio 1 organizado en funciones
 * 1. Escribe un programa que pida al usuario cuántos alumnos tiene un grupo.
 * 2. Después debe pedir las notas de cada alumno de ese grupo usando una estructura adecuada.
 * 3. El programa debe mostrar las notas introducidas,
 * 4. La media de todas las notas,
 * 5. La nota más alta
 * 6. la nota más baja.
 */
public class Ejercicio2 {
    public static void main(String[] args) {
        //1. Pedir numero de alumnos y crear array para ese numero de alumnos
        int numAlumnos = pideEntero("Introduce número de alumnos","Error, debes introducir un numero entero");
        int[] notas = new int[numAlumnos];
        // 2
        pideArrayEnteros(notas);
        // 3
        System.out.println("Notas introducidas");
        imprimeArray(notas);
        // 4
        System.out.println("Nota media: " + calcularMedia(notas));
        // 5
        System.out.println("La nota más alta es " + getMaximo(notas));
        // 5
        System.out.println("La nota más baja es " + getMinimo(notas));
    }

    /**
     * Devuelve 0 si el array está vacío
     */
    public static int getMaximo (int[] array) {
        int maximo = 0;
        if (array.length > 0) {
            maximo = array[0];
            for (int i = 1; i < array.length; i++) {
                if (maximo < array[i]) {
                    maximo = array[i];
                }
            }
        }
        return maximo;
    }

    /**
     * Devuelve 0 si el array está vacío
     */
    public static int getMinimo (int[] array) {
        int minimo = 0;
        try {
            minimo = array[0];
            if (array.length > 0) {
                for (int i = 1; i < array.length; i++) {
                    if (minimo > array[i]) {
                        minimo = array[i];
                    }
                }
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("ERROR: Array vacío. El mínimo devuelto será 0");
            minimo = 0;
        }
        return minimo;
    }

    public static double calcularMedia(int[] array) {
        double aculumador = 0;
        for (int i = 0; i < array.length; i++) {
            aculumador += array[i];
        }
        return aculumador / array.length;
    }


    public static void imprimeArray(int[] array) {
        for(int i=0;i<array.length;i++){
            System.out.println(array[i]);
        }
    }

    public static void pideArrayEnteros(int [] array){
      for(int i=0;i<array.length;i++){
          array[i]=pideEntero("Introduce elemento "+i+": ","Error,El elemento debe ser un numero entero");
      }
    }

    public static int pideEntero( String mensaje, String mensajeError){
        Scanner sc = new Scanner(System.in);
        int numero = 0;
        boolean noHayError = true;
        do {
            System.out.println(mensaje);
            try {
                numero = sc.nextInt();
                noHayError = true;
            } catch (InputMismatchException e) {
                System.out.println(mensajeError);
                noHayError = false;
                sc.nextLine(); // Limpiar buffer
            }

        } while (!noHayError);
        return numero;
    }

}









