 import java.util.Scanner;
public class Ejemplo2CondicionalCompleto{
	public static void main(String[] args){
	    Scanner teclado = new Scanner(System.in);
		int edad = 0;
		
		System.out.println("Introduce edad: ");
		edad = teclado.nextInt();
		
		
		//Condicional completo
		if(edad>=18){  //instrucciones si se cumple la condicion
						
			System.out.println("Mayor de edad");
		
		}else{   //instrucciones si NO se cumple la condicion
			System.out.println("Menor de edad");
		}
		System.out.println("Final del programa");
		
	}
}