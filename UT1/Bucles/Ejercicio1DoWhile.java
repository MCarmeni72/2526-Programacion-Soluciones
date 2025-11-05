/*
Pide un número entero (mayor de 0). Comenzando desde el 1, suma los números consecutivamente (1+2+3…) mientras el total de la suma no supere el número pedido.

*/
import java.util.Scanner;
public class Ejercicio1DoWhile{
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		int numero = 0;
		int suma = 0;
		int cont = 0;
		//pedir un numero > 0
		do{			
			System.out.print("Introduzca un número: ");
			numero = teclado.nextInt();
			if(!(numero>0)){
				System.out.println("Error, debes introducir un numero > 0");
			}
		}while(!(numero>0));
		
		do{
			suma+=cont;
			cont++;
			
		}while((suma+cont)<numero);
		
		System.out.println("Hemos sumado hasta el "+(cont-1)+" y la suma ha sido="+suma);
		
		
	}
}		