import java.util.Scanner;

/**
 * Suma de pares e impares: Pedir al usuario un número N
 * y mostrar la suma de los pares y de los impares hasta N.
 */

public class SumaParesImpares {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese un numero: ");
        int num1 = sc.nextInt();
        int sumaPares = 0;
        int sumaImpares = 0;
        for (int i = 1; i <= num1; i++) {  //usamos un For porque sé el numero de vueltas que tiene que dar el bucle, exactamente, N vueltas
            if(i % 2 == 0) { //numeros pares
                sumaPares += i;
            }else{
                sumaImpares += i;
            }
        }
        System.out.println("La suma de pares: " + sumaPares);
        System.out.println("La suma de impares: " + sumaImpares);


    }
}
