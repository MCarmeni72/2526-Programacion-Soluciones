/*
Crea un menú que inicie una variable a 1 y pida un número entero entre 0 y 2:
	- Si el usuario introduce un 1, el programa suma uno al valor de la variable y vuelve a pedir el número.
	- Si el usuario introduce un 2, el programa multiplica por 2 el valor de la variable y vuelve a pedir el número.
	- Si el usuario introduce un 0, el programa finaliza.
*/
import java.util.Scanner;

public class Ejercicio2DoWhile{
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		int variable = 1;
		int opcion = 0;
		
		do {
			System.out.println("\n\n~~~MENU~~~\n");
			System.out.println("1. Sumar 1");
			System.out.println("2. Multiplicar por 2");
			System.out.println("");
			System.out.println("0. Salir");
			System.out.println("");
			do {
				System.out.print("Seleccione una opción (0-2): ");
				opcion = teclado.nextInt();
				if (opcion < 0 || opcion > 2) {
					System.out.println("ERROR: opción no válida");
				}
			} while (opcion < 0 || opcion > 2);
			
			if (opcion != 0) {
				switch(opcion) {
					case 1:
						variable++;
						break;
					case 2:
						variable*=2;
						break;
					default:
						System.out.println("La opción escogida no es correcta");
				}
				System.out.println("La variable ahora vale " + variable);
			}
		} while (opcion != 0);
	}
}