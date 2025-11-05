public class Ejercicio0While{
	public static void main(String[] args) {
		
		int contador = 5;
		
		while(contador > 0) {
			System.out.println("Todavía quedan " + contador + " vueltas");
			contador = contador - 1;
		}
		
		System.out.println("Ya he terminado");
		
	}
}