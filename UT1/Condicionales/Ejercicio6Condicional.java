/* Una  tienda online ofrece descuentos según el total de la compra:
		Más de 1000€ -> 15% de descuento
		Entre 500€ y 1000€ -> 10% de descuento
		Menos de 500€ -> 5% de descuento
  	Realiza un programa que pida el importe y muestre el porcentaje de descuento aplicado, así como el importe resultante
*/
import java.util.Scanner;

public class Ejercicio6Condicional {
	public static void main(String[] args) {
		double importe = 0;
		double descuento = 0;
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Introduzca el importe de su compra: ");
		importe = teclado.nextDouble();
		
		if (importe > 1000) {
			descuento = 0.15;
		} else if (importe >= 500) {
			descuento = 0.10;
		} else {
			descuento = 0.05;
		}
		
		System.out.println("Se ha aplicado un descuento del " + (descuento * 100) + "%");
		System.out.println("El importe descontado es " + (importe * descuento) + " €");
	}
}