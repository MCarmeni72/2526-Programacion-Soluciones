import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio5 {
    public static void main(String[] args) {
        int t=0;
        t=pideEntero("Introduce tamaño del array","Error, dato incorrecto");
        int[] array=new int[t];
        rellenaArrayAleatorio(array);
        muestraArray(array);
        System.out.println("\nLa suma de los elementos del array es: "+sumaElementosArray(array));

    }

    /**
     * Método que genera un número aleatorio entre un máximo y un mínimo
     * @param lower valor mínimo del rango en el que se tiene que generar el valor
     * @param upper valor máximo del rango en el que se tiene que generar el valor
     * @return int numero entero generado
     */
    public static int generaNumeroAleatorio(int lower, int upper){
        return (int)(Math.random()*(upper-lower+1)+lower);
        /*int r;
        r = (int)(Math.random()*(upper-lower+1)+lower);
        return r;*/
    }

    /**
     * Método que rellena un array pasado como parámetro, con números aleatorios entre 0 y 9
     * @param array el array que se va a rellenar
     */
    public static void rellenaArrayAleatorio(int[] array){
        for(int i=0; i<array.length; i++){
           array[i]=generaNumeroAleatorio(0,9 );

        }
    }

    public static void muestraArray(int [] array){
        System.out.println("Datos del array: ");
        for(int i=0; i<array.length; i++){
            System.out.print(array[i]+" ");
        }
    }
    public static int sumaElementosArray(int[] array){
        int suma=0;
        for(int i=0; i<array.length; i++){
            suma+=array[i];
        }
        return suma;
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
