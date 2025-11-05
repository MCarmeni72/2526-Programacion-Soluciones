/* Dibujar un cuadrado de n x n con asteriscos. */

import java.util.Scanner;
public class Ejercicio6For{
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		System.out.print("Introduzca el valor de n: ");
		int n = teclado.nextInt();
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print("*");
			}
			System.out.println("");
		}
	}
}

/*
import java.util.Scanner;
public class Ejercicio6For{
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		System.out.print("Introduzca el valor de n: ");
		int n = teclado.nextInt();
		
		for (int fila = 1; fila <= n; fila++) {
			for (int columna = 1; columna <= n; columna++) {
				System.out.print("*");
			}
			System.out.println("");
		}
	}
}
*/