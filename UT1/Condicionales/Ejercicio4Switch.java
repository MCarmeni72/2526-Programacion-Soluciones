/*
Programa que pida el sueldo de un trabajador y su categoría, dependiendo de la categoría se le dará una bonificación en el neto a pagar.
Categoría = Bonificación:
A = 10%
B = 20%
C = 30%
D = 50%
Mostrar como resultado un mensaje que indique el sueldo base, la bonificación y el sueldo final.

*/
import java.util.Scanner;

public class Ejercicio4Switch{
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		double sueldoBase = 0;
		char categoria = 'X';
		double bonificacion = 0;
		double sueldoFinal = 0;
		
		System.out.print("Introduzca sueldo base: ");
		sueldoBase = teclado.nextDouble();
		
		System.out.print("Introduzca categoria (A,B,C ó D): ");
		categoria = teclado.next().charAt(0);  //recoger el primer caracter de una cadena introducida por teclado
		
		switch(categoria){
			case 'A': 	bonificacion=0.10;
						break;
			case 'B':	bonificacion=0.20;
						break;
			case 'C':	bonificacion=0.30;
						break;
			case 'D':	bonificacion=0.50;
						break;
			default:
						System.out.println("Categoria incorrecta, pruebe de nuevo");
		}
		if (!((categoria!='A')&&(categoria!='B')&&(categoria!='C')&&(categoria!='D'))){
			
			sueldoFinal = sueldoBase + sueldoBase*bonificacion;
			
			System.out.println("Sueldo base = "+sueldoBase+", bonificación ="+bonificacion+", sueldo final= "+sueldoFinal);
		}
		
		/*if (categoria=='A'||categoria=='B'||categoria=='C'||categoria=='D'){
			sueldoFinal = sueldoBase + sueldoBase*bonificacion;
			
			System.out.println("Sueldo base = "+sueldoBase+", bonificación ="+bonificacion+", sueldo final= "+sueldoFinal);
		}*/
		
	}
}