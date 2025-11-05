/*
	Mostrar la tabla de multiplicar de un número. Ejemplo,si me introducen 3:
	3 x 1 = 3
	3 x 2 = 6
	….
	3 x 10 = 30
*/
import java.util.Scanner;
public class Ejercicio4For{
	public static void main(String[] args) {
		int numero = 0;
		Scanner teclado = new Scanner(System.in);
		
		System.out.print("Introduzca el número: ");
		numero = teclado.nextInt();
		
		for (int i = 1; i <= 10; i++) {
			System.out.println(numero + " x " + i + " = " + (numero * i));
		}
	}
}