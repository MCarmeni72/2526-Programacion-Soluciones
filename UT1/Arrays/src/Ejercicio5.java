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

    public static int generaNumeroAleatorio(int lower, int upper){
        return (int)(Math.random()*(upper-lower+1)+lower);
        /*int r;
        r = (int)(Math.random()*(upper-lower+1)+lower);
        return r;*/
    }

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
