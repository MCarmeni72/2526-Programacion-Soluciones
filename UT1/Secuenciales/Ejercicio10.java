/*
En un curso la nota final se obtiene con estos criterios:
	40% del promedio de dos exámenes parciales
	40% de un examen final
	20% de un trabajo de investigación
Escribe un programa que pida esas calificaciones y muestre la nota final del estudiante.
 */
 import java.util.Scanner;

public class Ejercicio10 {
	public static void main(String[] args){
		Scanner teclado = new Scanner(System.in);
		
		double notaExamen1 = 0;
		double notaExamen2 = 0;
		double notaExamenFinal = 0;
		double notaTrabajo = 0;
		double notaFinal = 0;
		
		System.out.println("Introduzca la nota del primer examen: ");
		notaExamen1 = teclado.nextDouble();
		System.out.println("Introduzca la nota del segundo examen: ");
		notaExamen2 = teclado.nextDouble();
		System.out.println("Introduzca la nota del examen final: ");
		notaExamenFinal = teclado.nextDouble();
		System.out.println("Introduzca la nota del trabajo de investigación: ");
		notaTrabajo = teclado.nextDouble();
		
		notaFinal = 0.4 * (notaExamen1 + notaExamen2) / 2 + 0.4 * notaExamenFinal + 0.2 * notaTrabajo;
		//notaFinal = 0.2 * notaExamen1 + 0.2 * notaExamen2 + 0.4 * notaExamenFinal + 0.2 * notaTrabajo;
		
		System.out.println("La nota final es " + notaFinal);
	}
}