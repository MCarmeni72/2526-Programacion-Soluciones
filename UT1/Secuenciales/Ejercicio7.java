/*
 Realiza un programa que pida el precio de un producto y el porcentaje de descuento aplicado (en formato decimal, por ejemplo, 0.20 para un 20%). Calcula el importe descontado y el precio final a pagar.
*/

import java.util.Scanner;

public class Ejercicio7 {
	public static void main(String[] args) {
		double precioProducto = 0;
		double descuentoDecimal = 0;
		double precioDescontado = 0;
		
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Introduzca el precio del producto: ");
		precioProducto = teclado.nextDouble();
		
		System.out.println("Introduzca el porcentaje de descuento en formato decimal: ");
		descuentoDecimal = teclado.nextDouble();
		
		precioDescontado = precioProducto * descuentoDecimal;
		
		System.out.println("Se han descontado " + precioDescontado + " €");
		System.out.println("El total a pagar es " + (precioProducto - precioDescontado) + " €");
	}
}