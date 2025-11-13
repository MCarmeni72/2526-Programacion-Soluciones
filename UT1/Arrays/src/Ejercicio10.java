/*
 * 10. Desarrollar una aplicación que ayude a gestionar las notas de un colegio. Los alumnos se encuentran organizados
 * en grupos de 5 personas. Leer las notas (números enteros) del primer, segundo y tercer trimestre de un grupo
 * (cada alumno, en cada trimestre ocupa la misma posición en el array). Debes mostrar al final la nota media del
 * grupo en cada trimestre y la media del alumno que se encuentra en una posición dada (que el usuario
 * introduce por teclado).
 *
 * Organiza el programa en funciones.
 */

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio10 {
    public static void main(String[] args) {
        final int TAMANO_GRUPO = 5;
        int[] notasTrimestre1 = new int[TAMANO_GRUPO];
        int[] notasTrimestre2 = new int[TAMANO_GRUPO];
        int[] notasTrimestre3 = new int[TAMANO_GRUPO];

        // Leer las notas
        leerNotas(notasTrimestre1, notasTrimestre2, notasTrimestre3);
        // Nota media en cada trimestre
        mostrarNotasMedias(notasTrimestre1, notasTrimestre2, notasTrimestre3);
        // Nota de un alumno dado
        pedirAlumnoYMostrarNotas(TAMANO_GRUPO, notasTrimestre1, notasTrimestre2, notasTrimestre3);

    }

    private static void pedirAlumnoYMostrarNotas(int TAMANO_GRUPO, int[] notasTrimestre1, int[] notasTrimestre2, int[] notasTrimestre3) {
        int posicionAlumno;
        posicionAlumno = pideEntero("Introduzca la posición del alumno a consultar (1 - " + TAMANO_GRUPO + ")",
                "Debe introducir un número entero entre 1 y " + TAMANO_GRUPO,
                1,
                TAMANO_GRUPO);
        System.out.println("La nota media del alumno " + posicionAlumno + " es " + calcularMediaAlumno(posicionAlumno-1, notasTrimestre1, notasTrimestre2, notasTrimestre3));
    }

    private static void mostrarNotasMedias(int[] notasTrimestre1, int[] notasTrimestre2, int[] notasTrimestre3) {
        System.out.println("La nota media del primer trimestre es " + calcularMediaTrimestre(notasTrimestre1));
        System.out.println("La nota media del segundo trimestre es " + calcularMediaTrimestre(notasTrimestre2));
        System.out.println("La nota media del tercer trimestre es " + calcularMediaTrimestre(notasTrimestre3));
    }

    private static void leerNotas(int[] notasTrimestre1, int[] notasTrimestre2, int[] notasTrimestre3) {
        leerNotas(notasTrimestre1, "Introduzca las notas del primer trimestre");
        leerNotas(notasTrimestre2, "Introduzca las notas del segundo trimestre");
        leerNotas(notasTrimestre3, "Introduzca las notas del tercer trimestre");
    }

    public static double calcularMediaAlumno(int posicionAlumno, int[] notasTrimestre1, int[] notasTrimestre2, int[] notasTrimestre3) {
        return ((notasTrimestre1[posicionAlumno] + notasTrimestre2[posicionAlumno] + notasTrimestre3[posicionAlumno]) / 3.0);
    }

    public static double calcularMediaTrimestre(int[] notasTrimestre) {
        double resultado = 0;
        for (int i = 0; i < notasTrimestre.length; i++) {
            resultado += notasTrimestre[i];
        }
        return resultado / notasTrimestre.length;
    }

    public static void leerNotas(int[] notasTrimestre, String mensaje) {
        System.out.println(mensaje);
        for (int i = 0; i < notasTrimestre.length; i++) {
            notasTrimestre[i] = pideEntero("Introduzca la nota del alumno " + (i + 1),
                    "Debe introducir un número entero entre 0 y 10",
                    0,
                    10);
        }
    }

    /**
     * Método que pide un valor entero validado (sin errores de escritura), si el usuario se equivoca vuelva a pedirlo
     * las veces necesarias hasta que el dato sea correcto.
     *
     * @param mensaje      Texto que le explica al usuario qué valor debe introducir
     * @param mensajeError Texto que le explica al usuario qué error se ha cometido, para que vuelva a meter el dato
     * @param valorMinimo  Valor mínimo permitido
     * @param valorMaximo  Valor máximo permitido
     * @return número entero validado sin ningún error
     */
    public static int pideEntero(String mensaje, String mensajeError, int valorMinimo, int valorMaximo) {
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

        } while (!noHayError && numero >= valorMinimo && numero <= valorMaximo);
        return numero;
    }
}

