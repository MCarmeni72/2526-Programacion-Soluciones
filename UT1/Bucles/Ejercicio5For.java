/* Mostrar todas las tablas del 1 al 10. */

public class Ejercicio5For{
	public static void main(String[] args) {
		for (int i = 1; i <= 10; i++) {
			System.out.println("\n\nTabla del " + i + "\n");
			for (int j = 1; j <= 10; j++) {
				System.out.println(i + " x " + j + " = " + (i * j));
			}
		}
	}
}
/*

Versión con variables *numero* e *i*

public class Ejercicio5For{
	public static void main(String[] args) {
		for (int numero = 1; numero <= 10; numero++) {
			System.out.println("\n\nTabla del " + numero + "\n");
			for (int i = 1; i <= 10; i++) {
				System.out.println(numero + " x " + i + " = " + (numero * i));
			}
		}
	}
}
*/