/*
Un pintor necesita 0,2 litros de pintura por metro cuadrado de pared. Haz un programa que pida las medidas de una pared (alto y ancho, en metros) y calcule cuántos litros de pintura serán necesarios.
*/
import java.util.Scanner;

public class Ejercicio8 {
	public static void main(String[] args){
		Scanner teclado = new Scanner(System.in);
		
		double alto = 0;
		double ancho = 0;
		double litrosTotales = 0;
		
		System.out.println("Introduce el alto del muro:");
		alto = teclado.nextDouble();
		System.out.println("Introduce el ancho del muro:");
		ancho = teclado.nextDouble();
		
		litrosTotales = 0.2 * ancho * alto;
		
		System.out.println("Necesitará " + litrosTotales + " litros de pintura");
	}
}