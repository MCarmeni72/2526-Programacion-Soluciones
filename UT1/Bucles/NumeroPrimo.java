import java.util.Scanner;

/**
Pedir un número e indicar si es primo o no.

 */
public class NumeroPrimo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numero = 0;
        int contadorDivisores = 0;
        System.out.print("Introduzca un numero: ");
        numero = sc.nextInt();

        //Solución 1
     /*   for (int i = 1; i <= numero; i++) {
            if(numero % i == 0) {
                contadorDivisores++;
            }
        }
        if(contadorDivisores<=2){
            System.out.println("El numero es primo");
        }else{
            System.out.println("El numero no es primo");
        }

        */

        //solucion 2 más óptima
        boolean divisorEncontrado = false;
        int i=2;
        while(i<numero && !divisorEncontrado){
            if(numero%i==0) {
                divisorEncontrado = true;
            }
            i++;
        }
        if(!divisorEncontrado){
            System.out.println("El numero es primo");
        }else{
            System.out.println("El numero no es primo");
        }






    }
}
