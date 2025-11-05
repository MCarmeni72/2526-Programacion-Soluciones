/*
 Crea un programa que solicite el radio de un círculo (puede tener decimales) y calcule tanto su longitud de circunferencia como su superficie.
 */
 
import java.util.Scanner;

public class Ejercicio6 {
	public static void main(String[] args){
		Scanner teclado = new Scanner(System.in);
		final double PI = 3.1416;
		double radio = 0;
		double longitudCircunferencia = 0;
		System.out.println("Introduce el valor del radio:");
		radio = teclado.nextDouble();
		
		longitudCircunferencia = 2 * PI * radio;
		
		System.out.println("La longitud de la circunferencia de radio " + radio + " es de " + longitudCircunferencia);
		
		System.out.println("La superficie de la circunferencia de radio " + radio + " es " + (PI * radio * radio));
		
	}
}