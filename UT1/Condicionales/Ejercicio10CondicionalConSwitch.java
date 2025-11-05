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

public class Ejercicio10CondicionalConSwitch {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		int nota=0;
				
		System.out.print("Introduzca nota: ");
		nota = teclado.nextInt();
		
		switch (nota){
			
			case 0,1,2,3,4: System.out.println("Suspenso");
							break;
					
			case 5: System.out.println("Aprobado");
					break;
			case 6: System.out.println("Bien");
					break;
			case 7,8: System.out.println("Notable");
					break;
			case 9: System.out.println("Sobresaliente");
					break;
			case 10: System.out.println("Matricula");
					break;
			default: System.out.println("Se ha introducido una nota NO VÁLIDA");
					break;
		}
	}
}