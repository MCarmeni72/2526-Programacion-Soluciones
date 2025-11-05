import java.util.Scanner;

public class Ejercicio4Condicional {
	public static void main(String[] args){
		
		Scanner teclado = new Scanner(System.in);
		
		double temp = 0;
				
		System.out.println("Introduzca temperatura actual: ");
		temp = teclado.nextDouble();
		
		if(temp<0){
			System.out.println("Hace mucho frio");
		}else if(temp<=20){
			System.out.println("Temperatura fresca");
		}else{
			System.out.println("Hace calor");
		}
		
		
		
	}
}