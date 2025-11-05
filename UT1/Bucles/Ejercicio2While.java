// Comenzando desde el 1, suma los números consecutivamente (1+2+3…) mientras el total de la suma no supere un millón.

public class Ejercicio2While{
	public static void main(String[] args) {
		int contador = 1, suma = 0;
		
		while (suma < 1000000) {
			suma += contador; // suma = suma + contador
			contador++; // contador = contador + 1
		}
		
		System.out.println("El valor de la suma es: " + suma);
		System.out.println("El último número sumado es: " + (contador - 1));
	}
}