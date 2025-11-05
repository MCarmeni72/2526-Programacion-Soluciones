import java.util.Scanner;

public class Pedir3NumerosSinFunciones {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double nota1, nota2, nota3;
        do{
            System.out.println("Introduzca la nota 1: ");
            nota1 = sc.nextDouble();
            if(nota1<0||nota1>10){
                System.out.println("Nota invalida");
            }
        }while(nota1<0||nota1>10);
        do{
            System.out.println("Introduzca la nota 2: ");
            nota2 = sc.nextDouble();
            if(nota2<0||nota2>10){
                System.out.println("Nota invalida");
            }
        }while(nota2<0||nota2>10);
        do{
            System.out.println("Introduzca la nota 3: ");
            nota3 = sc.nextDouble();
            if(nota3<0||nota3>10){
                System.out.println("Nota invalida");
            }
        }while(nota3<0||nota3>10);

        System.out.println("Las notas introducidas son: "+nota1+", "+nota2+", "+nota3);
    }
}
