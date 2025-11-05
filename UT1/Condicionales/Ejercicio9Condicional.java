/*Realiza un programa que pida el día de la semana, el turno realizado en ese día y el número de horas trabajadas. A partir de estos datos, el programa mostrará el salario diario de un empleado. Hay que tener en cuenta que el trabajador puede tener 2 turnos distintos (mañana y noche), y las tarifas son:
Mañana: 12€/hora
Noche: 15€/hora
Si es sábado o domingo, sumar 3€/hora adicional al turno
*/
import java.util.Scanner;

public class Ejercicio9Condicional {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		int diaSemana=0, turno=0, horas=0;
		
		int precioTurno=0, aumentoFinde=0;
		
		int salario=0;
		
		System.out.print("Introduzca diaSemana ");
		diaSemana = teclado.nextInt();
		System.out.print("Introduzca turno: ");
		turno=teclado.nextInt();
		System.out.print("Introduzca horas:");
		horas=teclado.nextInt();
		
		if(turno==1){ //turno de mañanas
			precioTurno=12;
		}else{ //turno de tardes 
			precioTurno=15;
		}
		
		if(diaSemana==6||diaSemana==7){//sabado o domingo
			aumentoFinde=3;
		}
		
		salario=((precioTurno+aumentoFinde)*horas);
		
		System.out.println("El salario es: "+salario);
	}
}