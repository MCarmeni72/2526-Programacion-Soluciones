/*
Pide un número entero entre 1 y 10. Si el número introducido no está en dicho rango, vuelve a pedir el número.
*/
import java.util.Scanner;

public class Ejercicio3DoWhile{
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		int numero = 0;
		
		do {
			System.out.print("Introduzca un número entre 1 y 10: ");
			numero = teclado.nextInt();
			if (!(numero >= 1 && numero <= 10)) {
				System.out.println("El número introducido no es correcto. Por favor asegúrese de que el número está entre 1 y 10.");
			}
		} while(!(numero >= 1 && numero <= 10));
		
		System.out.println("El número introducido es " + numero);
	}
}