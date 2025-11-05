/* 
Realiza un programa que pida 3 números y los ordene de menor a mayor, mostrando el resultado. 
*/

import java.util.Scanner;

public class Ejercicio7CondicionalB {
	public static void main(String[] args) {
		
		int numeroA=0, numeroB=0, numeroC=0;
		int menor=0, medio=0, mayor=0;
		Scanner teclado = new Scanner(System.in);
		
		System.out.print("Introduzca el valor del primer número: ");
		numeroA = teclado.nextInt();
		System.out.print("Introduzca el valor del segundo número: ");
		numeroB = teclado.nextInt();
		System.out.print("Introduzca el valor del tercer número: ");
		numeroC = teclado.nextInt();
		
		if (numeroA < numeroB && numeroA < numeroC) {
			menor = numeroA;
			if (numeroB < numeroC) { //ABC
				medio = numeroB;
				mayor = numeroC;
			} else { //ACB
				medio = numeroC;
				mayor = numeroB;
			}
		} else if (numeroB < numeroA && numeroB < numeroC) {
			menor = numeroB;
			if (numeroA < numeroC) { //BAC
				medio = numeroA;
				mayor = numeroC;
			} else { //BCA
				medio = numeroC;
				mayor = numeroA;
			}
		} else {
			menor = numeroC;
			if (numeroA < numeroB) { //CAB
				medio = numeroA;
				mayor = numeroB;
			} else { //CBA
				medio = numeroB;
				mayor = numeroA;
			}
		}
		System.out.println(menor + "-" + medio+ "-" + mayor);//ABC
	}
}