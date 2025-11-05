/*
Calculadora 1.0: Algoritmo que lea dos números, calculando y escribiendo el valor de su suma, resta, producto, división.
*/
import java.util.Scanner;

public class Ejercicio9 {
	public static void main(String[] args){
		Scanner teclado = new Scanner(System.in);
		
		double numeroA=0, numeroB=0;
		
		System.out.println("Introduzca el primer número: ");
		numeroA = teclado.nextDouble();
		System.out.println("Introduzca el segundo número: ");
		numeroB = teclado.nextDouble();
		
		System.out.println(numeroA + " + " + numeroB + " = " + (numeroA + numeroB));
		System.out.println(numeroA + " - " + numeroB + " = " + (numeroA - numeroB));
		System.out.println(numeroA + " * " + numeroB + " = " + (numeroA * numeroB));
		System.out.println(numeroA + " / " + numeroB + " = " + (numeroA / numeroB));
	}
}