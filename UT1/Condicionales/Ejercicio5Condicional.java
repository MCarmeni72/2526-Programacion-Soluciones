import java.util.Scanner;

public class Ejercicio5Condicional {
	public static void main(String[] args){
		
		Scanner teclado = new Scanner(System.in);
		
		double nota = 0;
		int nivel =0; //nivel = 1 es básico, nivel = 2 es medio, nivel = 3 es avanzado
				
		System.out.println("Introduzca nota: ");
		nota = teclado.nextDouble();
		
		System.out.println("Introduzca nivel (1->Basico, 2->Medio, 3->Avanzado: ");
		nivel = teclado.nextInt();
		/*
		//FORMA 1
		if((nivel==1)&&(nota>=70)){
			System.out.prinln("Aprobado");
		}else if((nivel==2)&&(nota>=80)){
			System.out.prinln("Aprobado");
		}else if((nivel==3)&&(nota>=90)){	
			System.out.prinln("Aprobado");
		}else{
			System.out.prinln("Suspenso");
		}
		*/
		
		//FORMA 2 -> MUCHO MAS EFICIENTE
		//if((nivel==3)&&(nota>=90) || ((nivel==2)&&(nota>=80)) || ((nivel==1)&&(nota>=70))){
		//no es necesario preguntar por el nivel = 3 porque todas las notas por encima de 90 son aprobado
		if((nota>=90) || ((nivel==2)&&(nota>=80)) || ((nivel==1)&&(nota>=70))){
			System.out.println("Aprobado");
		}else{
			System.out.println("Suspenso");
		}
	}
}