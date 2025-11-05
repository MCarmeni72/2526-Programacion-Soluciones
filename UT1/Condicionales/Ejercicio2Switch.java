/*Programa que pida un mes, mediante un número entero (1-12), y almacene en una variable “días”, el número de días que tiene el mes (enero -> 31, febrero -> 28, …). Al finalizar el programa mostrará un mensaje diciendo el mes y los días que tiene (solo se escribirá una sola línea para imprimir, al final del programa).*/

import java.util.Scanner;

public class Ejercicio2Switch{
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		int mes=0;
		int dias =0;
		
		System.out.print("Introduzca número del mes: ");
		mes = teclado.nextInt();
		
		switch(mes){
			case 1,3,5,7,8,10,12:
				dias = 31;
				break;
			case 2:
				dias=28;
				break;
			case 4,6,9,11:
				dias=30;
				break;
				
		}
		
		//opcion 1: si no ha entrado en ninguna opcion de case, es porque el mes es incorrecto
		//if(dias==0){ 
		
		//opcion 1: pregunto por el intervalo de meses
		if(mes<=0 || mes>12){
			System.out.println("HAS INTRODUCIDO UN NUMERO DE MES INCORRECTO");
		}else{	
			System.out.println("El mes "+mes+ " tiene "+ dias+ " días");
		}
	}
}