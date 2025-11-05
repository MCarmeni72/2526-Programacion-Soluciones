/*Programa que pida la nota de un alumno (entre 0 y 10, números enteros), y muestre la calificación asociada en texto, según los siguientes criterios:
Nota menor que 5 -> suspenso
Nota igual a 5 -> Aprobado
Nota igual a 6 -> Bien
Nota igual a 7 u 8 -> Notable
Nota igual a 9 -> Sobresaliente
Nota igual a 10 -> Matrícula
Cualquier otro valor -> mensaje de error
*/
import java.util.Scanner;

public class Ejercicio10Condicional {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		int nota=0;
				
		System.out.print("Introduzca nota: ");
		nota = teclado.nextInt();
		
		if(nota<0||nota>10){
			System.out.println("Error, nota no valida");
		}else{ //nota correcta entre 0 - 10
			if(nota<5){
				System.out.println("Suspenso");
			}else if(nota<6){
				System.out.println("Aprobado");
			}else if(nota<7){
				System.out.println("Bien");	
			}else if(nota<9){
				System.out.println("Notable");	
			}else if(nota<10){
				System.out.println("Sobresaliente");
			}else{
				System.out.println("Matricula");
			}
		}
	}
}