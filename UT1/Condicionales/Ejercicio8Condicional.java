/*
Calcula el costo de una llamada telefónica:
Hasta 3 minutos: 0.70€
Más de 3 minutos: 0.70€ + 0.25€ por minuto adicional
Realiza un programa que pida la duración de una llamada y muestra el costo de la misma.
*/

import java.util.Scanner;

public class Ejercicio8Condicional {
	public static void main(String[] args) {
		int minutosDuracion = 0;
		double coste = 0.7;
		
		Scanner teclado = new Scanner(System.in);
		System.out.print("Introduzca la duración de la llamada (en minutos): ");
		minutosDuracion = teclado.nextInt();
		
		if (minutosDuracion > 3) {
			coste = coste + ((minutosDuracion - 3) * 0.25);
		}
		
		System.out.println("El coste de la llamada es de " + coste + " €");
	}
}