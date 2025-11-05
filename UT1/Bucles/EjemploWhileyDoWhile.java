import java.util.Scanner;
public class EjemploWhileyDoWhile{
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		int numero = 0;
		
		//con While (no es optimo, porque repito codigo
		/*System.out.print("Introduzca un número (0 para salir): ");
		numero = teclado.nextInt();
		
		while(numero != 0){
			System.out.println("numero introducido: "+numero);
			System.out.print("Introduzca un número (0 para salir): ");
			numero = teclado.nextInt();
		}*/
		
		do{			
			System.out.print("Introduzca un número (0 para salir): ");
			numero = teclado.nextInt();
			System.out.println("numero introducido: "+numero);
		}while(numero != 0);
	}
}