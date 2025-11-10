import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio7 {
    public static void main(String[] args) {
        int t=0;
        t=pideEntero("Introduce tamaño del array 1","Error, dato incorrecto");
        int[] array1 = new int[t];
        int[] array2 = new int[t];
        rellenaArrayAleatorio(array1);
        rellenaArrayAleatorio(array2);
        int []suma = sumaArray(array1,array2);

        muestraArray(array1,"Los datos del primer array son: ");
        muestraArray(array2,"Los datos del segundo array son: ");

        if(suma != null) {
            muestraArray(suma, "Los datos del array de SUMA son: ");
        }else{
            System.out.println("No se puede mostrar la suma porque los arrays tienen tamaño distinto");
        }


    }

    /**
     * Método que crea un array con la suma de dos arrays del mismo tamaño
     * @param array1
     * @param array2
     * @return el array con la suma si array 1 y array2 son del mismo tamaño / devuelve null si son de tamaño distinto
     */
    public static int[] sumaArray(int[] array1, int[] array2) {
        int[] arraySuma = null;
        if(array1.length==array2.length) {
            arraySuma = new int[array1.length];
            for (int i = 0; i < array1.length; i++) {
                arraySuma[i] = array1[i] + array2[i];
            }
        }
        return arraySuma;
    }


    /**
     * Método que genera un número aleatorio entre un máximo y un mínimo
     * @param lower valor mínimo del rango en el que se tiene que generar el valor
     * @param upper valor máximo del rango en el que se tiene que generar el valor
     * @return int numero entero generado
     */
    public static int generaNumeroAleatorio(int lower, int upper) {
        return (int) (Math.random() * (upper - lower + 1) + lower);
    }

    /**
     * Método que rellena un array pasado como parámetro, con números aleatorios entre 0 y 9
     * @param array el array que se va a rellenar
     */
    public static void rellenaArrayAleatorio(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = generaNumeroAleatorio(0, 99);
        }
    }

    /**
     * Método que muestra los elementos de un array, por consola
     * @param array array mostrado por consola
     * @param msn Mensaje que me da información del contenido del array
     */
    public static void muestraArray(int [] array, String msn){
        System.out.println(msn);
        for(int i=0; i<array.length; i++){
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }

    /**
     * Método que pide un valor entero validado (sin errores de escritura), si el usuario se equivoca vuelva a pedirlo
     * las veces necesarias hasta que el dato sea correcto.
     * @param mensaje Texto que le explica al usuario qué valor debe introducir
     * @param mensajeError Texto que le explica al usuario qué error se ha cometido, para que vuelva a meter el dato
     * @return número entero validado sin ningún error
     */
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
