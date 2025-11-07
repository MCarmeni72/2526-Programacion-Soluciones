/*
 * 4. A partir del ejercicio 3, añade la opción de imprimir los elementos que superan un valor concreto,
 *  su valor máximo y su valor mínimo.
 */

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio4 {
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
            System.out.println("3. Consultar posición de número");
            System.out.println("4. Consultar posición de máximo y mínimo");
            System.out.println("5. Buscar números superiores");
            System.out.println("6. Imprimir números superiores");
            System.out.println("");
            System.out.println("0. Salir");
            System.out.println("");
            opcion = pideEnteroAcotado("Escoja una opción", "Debe introducir una opción entre 0 y 6",0, 6);
            switch (opcion) {
                case 1:
                    imprimeArray(arrayNumeros);
                    break;
                case 2:
                    imprimeArrayInverso(arrayNumeros);
                    break;
                case 3:
                    ejecutarOpcionBuscarPosicion(arrayNumeros);
                    break;
                case 4:
                    ejecutarOpcionBuscarMaximoMinimo(arrayNumeros);
                    break;
                case 5:
                    ejecutarOpcionContarNumerosMayores(arrayNumeros);
                    break;
                case 6:
                    ejecutarOpcionImprimirNumerosSuperiores(arrayNumeros);
                    break;
            }
        } while (opcion >= 1 && opcion <= 6);
    }

    public static void ejecutarOpcionImprimirNumerosSuperiores(int[] arrayNumeros){
        int numeroASuperar = 0;
        numeroASuperar = pideEntero("Introduce el número a superar: ", "Debe introducir un número entero");
        int[] numerosMayores = obtenerNumerosMayoresQue(arrayNumeros, numeroASuperar);
        imprimeArray(numerosMayores);
        System.out.println("El valor máximo es " + getMaximo(numerosMayores));
        System.out.println("El valor minimo es " + getMinimo(numerosMayores));
    }


    public static int[] obtenerNumerosMayoresQue(int[] arrayNumeros, int numeroASuperar) {
        int cantidadNumerosMayores = contarNumerosMayoresQue(arrayNumeros, numeroASuperar);
        int[] numerosMayores = new int[cantidadNumerosMayores];
        int j = 0;
        for (int i = 0; i < arrayNumeros.length; i++) {
            if (arrayNumeros[i] > numeroASuperar) {
                numerosMayores[j] = arrayNumeros[i];
                j++;
            }
        }
        return numerosMayores;
    }

    public static void ejecutarOpcionContarNumerosMayores(int[] arrayNumeros) {
        int numeroASuperar = 0;
        int cantidadNumerosMayores = 0;
        numeroASuperar = pideEntero("Introduce el número a superar: ", "Debe introducir un número entero");
        cantidadNumerosMayores = contarNumerosMayoresQue(arrayNumeros, numeroASuperar);
        if (cantidadNumerosMayores == 0) {
            System.out.println("No existe ningún número superior a " + numeroASuperar);
        } else {
            System.out.println("Hay " + cantidadNumerosMayores + " números mayores que " + numeroASuperar);
        }
    }

    public static void ejecutarOpcionBuscarMaximoMinimo(int[] arrayNumeros) {
        int numeroABuscar = 0;
        int posicionNumeroABuscar = 0;
        numeroABuscar = getMaximo(arrayNumeros);
        posicionNumeroABuscar = buscarNumero(arrayNumeros, numeroABuscar);
        System.out.println("El máximo es " + numeroABuscar + " y está en la posición " + (posicionNumeroABuscar+1));
        numeroABuscar = getMinimo(arrayNumeros);
        posicionNumeroABuscar = buscarNumero(arrayNumeros,numeroABuscar);
        System.out.println("El mínimo es " + numeroABuscar + " y está en la posición " + (posicionNumeroABuscar+1));
    }

    public static void ejecutarOpcionBuscarPosicion(int[] arrayNumeros) {
        int numeroABuscar = 0;
        int posicionNumeroABuscar = 0;
        numeroABuscar = pideEntero("Introduce el número a buscar: ", "Debes introducir un número entero");
        posicionNumeroABuscar = buscarNumero(arrayNumeros, numeroABuscar);
        if (posicionNumeroABuscar == -1) {
            System.out.println("El número " + numeroABuscar + " no está en el array");
        } else {
            System.out.println("El número " + numeroABuscar + " está en la posición " + (posicionNumeroABuscar+1));
        }
    }

    public static int contarNumerosMayoresQue(int[] array, int numeroLimite) {
        int contador = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > numeroLimite) {
                contador++;
            }
        }
        return contador;
    }

    /**
     * Devuelve la posición, y si no existe devuelve -1
     */
    public static int buscarNumero(int[] array, int numeroABuscar) {
        int posicionNumero = -1;
        int i = 0;
        while ( i < array.length && posicionNumero == -1) {
            if (array[i] == numeroABuscar) {
                posicionNumero = i;
            }
            i++;
        }
        return posicionNumero;
    }

    public static void imprimeArrayInverso(int[] array) {
        for(int i=array.length-1;i>=0;i--){
            System.out.println(array[i]);
        }
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