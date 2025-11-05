/*
Imprimir los números del 1 hasta el número que indique el usuario. Que no salga la coma después del último
*/
import java.util.Scanner;
public class Ejercicio1For{
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		int valorFinal=0;
		//int i;
		
		System.out.print("Introduzca valor final: ");
		valorFinal = teclado.nextInt();
		
		for(int i=1; i<=valorFinal ; i++){
			if(i==valorFinal){
				System.out.print(i);
			}else{
				System.out.print(i+", ");
			}
		}
		// la siguiente linea comentada da error, porque la variable i está fuera
		// de su ámbito
		
		//System.out.println("valor de i: "+ i); 
		
		System.out.println("valor Final: "+ valorFinal);
		
	}
}
		