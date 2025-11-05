import java.util.Scanner;

public class Ejercicio3Condicional {
	public static void main(String[] args){
		Scanner teclado = new Scanner(System.in);
		
		double num1 = 0;
		double num2 = 0;
		
		System.out.println("Introduzca numero 1: ");
		num1 = teclado.nextDouble();
		
		System.out.println("Introduzca numero 2: ");
		num2 = teclado.nextDouble();
		
		if(num1==num2){
			System.out.println("Son iguales");
		}else if(num1>num2){
			System.out.println("El mayor es: "+num1);
		}else{
			System.out.println("El mayor es: "+num2);
		}


		if(num1==num2){
			System.out.println("Son iguales");
		}
		if(num1>num2){
			System.out.println("El mayor es: "+num1);
		}
		if(num<num2){
			System.out.println("El mayor es: "+num2);
		}	




		
	}
}	