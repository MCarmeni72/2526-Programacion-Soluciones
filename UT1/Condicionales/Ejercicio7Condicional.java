/* 
Realiza un programa que pida 3 números y los ordene de menor a mayor, mostrando el resultado. 
*/

import java.util.Scanner;

public class Ejercicio7Condicional {
	public static void main(String[] args) {
		
		int numeroA=0, numeroB=0, numeroC=0;
		Scanner teclado = new Scanner(System.in);
		
		System.out.print("Introduzca el valor del primer número: ");
		numeroA = teclado.nextInt();
		System.out.print("Introduzca el valor del segundo número: ");
		numeroB = teclado.nextInt();
		System.out.print("Introduzca el valor del tercer número: ");
		numeroC = teclado.nextInt();
		
		if (numeroA < numeroB && numeroA < numeroC) {
			if (numeroB < numeroC) {
				System.out.println("El orden es: " + numeroA + "-" + numeroB+ "-" + numeroC);//ABC
			} else {
				System.out.println("El orden es: " + numeroA + "-" + numeroC+ "-" + numeroB);//ACB
			}
		} else if (numeroB < numeroA && numeroB < numeroC) {
			if (numeroA < numeroC) {
				System.out.println("El orden es: " + numeroB + "-" + numeroA+ "-" + numeroC);//BAC
			} else {
				System.out.println("El orden es: " + numeroB + "-" + numeroC+ "-" + numeroA);//BCA
			}
		} else {
			if (numeroA < numeroB) {
				System.out.println("El orden es: " + numeroC + "-" + numeroA+ "-" + numeroB);//CAB
			} else {
				System.out.println("El orden es: " + numeroC + "-" + numeroB+ "-" + numeroA);//CBA
			}
		}
	}
}