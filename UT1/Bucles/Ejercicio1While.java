// Pide un número entero (mayor de 0) e imprime todos los números del 1 hasta dicho número (incluido).
import java.util.Scanner;

public class Ejercicio1While{
	public static void main(String[] args) {
		int numero = 0;
		int contador = 1;
		Scanner teclado = new Scanner(System.in);
		
		System.out.print("Introduzca un número mayor de 0: ");
		numero = teclado.nextInt();
		
		while (contador <= numero) {
			System.out.println(contador);
			contador++;
		}
	}
}