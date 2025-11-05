/*
Imprimir los números pares del 1 al 20.
*/

public class Ejercicio2For{
	public static void main(String[] args) {
		//opcion 1.
		/*for(int i=1;i<=20; i++){
			if(i%2==0){
				System.out.println(i);
			}
		}*/			
		
		//opcion 2
		for(int i=2;i<=20;i+=2){
			System.out.println(i);
		}
	}
}