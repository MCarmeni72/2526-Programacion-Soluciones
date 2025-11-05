import java.util.Scanner;

/**
 * Calcular el factorial de un número dado por el usuario.
 */
public class Factorial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce un numero: ");
        int num1 = sc.nextInt();
        int factorial = 1;

        for(int i=1;i<=num1;i++){
            //factorial = factorial * i;
            factorial *= i;
        }

        System.out.println("La factorial del numero "+num1+" es: "+factorial);


    }
}
