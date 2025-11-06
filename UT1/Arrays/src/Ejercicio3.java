/*
 * 3. Escribe un programa que pida 10 números enteros por teclado, los almacene en un array, y a continuación
 *  muestre un menú en el que permita:
 *  - Mostrar esos elementos.
 *  - Mostrar esos elementos en orden inverso al que fueron introducidos.
 *  - Comprobar si un número existe. Si existe se mostrará la posición del número en el array, y si no existe
 * lo indicará.
 *  - Consultar cuál es el máximo y el mínimo, y en qué posición están.
 *  - Consultar cuántos números superan un valor concreto.
 *
 * Se debe implementar mediante funciones. En el caso de la búsqueda, la función deberá devolver -1 si el
 * elemento no existe. Las funciones para localizar un número, obtener la posición, calcular el mínimo o el máximo…
 * deben devolver valores, no imprimirlos.
 */

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio3 {
    public static void main(String[] args) {
        final int TAMANO_ARRAY = 10;
        int[] arrayNumeros = new int[TAMANO_ARRAY];
        int opcion = 0;
        System.out.println("Introduzca los " + TAMANO_ARRAY + " números");
        pideArrayEnteros(arrayNumeros);

        do {
            System.out.println("MENU");
            System.out.println("1. Mostrar elementos");
            System.out.println("2. Mostrar elementos en orden inverso");
            System.out.println("");
            System.out.println("0. Salir");
            System.out.println("");
            opcion = pideEnteroAcotado("Escoja una opción", "Debe introducir una opción entre 0 y 2",0, 2);
            switch (opcion) {
                case 1:
                    imprimeArray(arrayNumeros);
                    break;
            }
        } while (opcion >= 1 && opcion <= 2);
    }

    /*
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

    public static int pideEnteroAcotado(String mensaje, String mensajeError, int numeroMin, int numeroMax){
        int numero = 0;
        do {
            numero = pideEntero(mensaje, mensajeError);
            if(numero<numeroMin||numero>numeroMax){
                System.out.println(mensajeError);
            }
        } while(numero<numeroMin||numero>numeroMax);
        return numero;
    }
}