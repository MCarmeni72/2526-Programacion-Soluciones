import java.util.Scanner;

public class Ejercicio1Condicional {
	public static void main(String[] args){
		Scanner teclado = new Scanner(System.in);
		
		double grade1 = 0;
		double grade2 = 0;
		double average = 0;
		
		
		System.out.println("Introduzca la nota 1: ");
		grade1 = teclado.nextDouble();
		System.out.println("Introduzca la nota 2: ");
		grade2 = teclado.nextDouble();
		
		average = (grade1+grade2)/2;
		
		System.out.println("La media de las notas "+grade1+" y "+grade2+" es: "+average);
		
		/*if(average>=5){
			System.out.println("APTO");
		}
		if(average<5){
			System.out.println("No APTO");
		}*/
		
		//opcion 1
		if(average>=5){
			System.out.println("APTO");
		}
		else{
			System.out.println("No APTO");
		}
		
		//opcion 2
		if(average<5){
			System.out.println("NO APTO");
		}
		else{
			System.out.println("APTO");
		}
		
	}
}	