/*
Calculadora: Crea un programa que pida al usuario dos números (que pueden tener decimales) y ofrezca al usuario cuatro opciones:
Sumar
Restar
Multiplicar
Dividir
Según lo que el usuario elija, mostrar la operación matemática que corresponde y su resultado.

*/
import java.util.Scanner;

public class Ejercicio3Switch{
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		double num1=0,num2=0;
		int opcion=0;
		double salida=0;
		String operacion = "";
		
			
		System.out.print("Introduzca número 1: ");
		num1 = teclado.nextInt();
		
		System.out.print("Introduzca número 2: ");
		num2 = teclado.nextInt();
		
		System.out.print("1. suma \n2. resta \n3. multiplicación \n4. division \nIntroduce opción: ");
		opcion = teclado.nextInt();
		
		switch(opcion){
			case 1: //sumar
					salida = num1+num2;
					operacion=" + ";
					break;
			case 2: //restar
					salida = num1 - num2;
					operacion=" - ";
					break;
			case 3: //multiplicar
					salida = num1*num2;
					operacion=" * ";
					break;
			case 4: //dividir
					salida = num1/num2;
					operacion=" / ";
					break;
			default:
					System.out.println("Opcion NO Válida");
		}
		
		System.out.println(num1 + operacion + num2 + " = " +salida);
		
	}
}