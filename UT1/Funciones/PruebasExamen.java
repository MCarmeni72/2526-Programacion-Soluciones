import java.util.Scanner;

public class PruebasExamen {
    public static void main(String[] args) {
   int primero =0;
   int segundo =0;
   do{
       System.out.println("Introduce primero");
       primero =new Scanner(System.in).nextInt();
       System.out.println("Introduce segundo");
       segundo =new Scanner(System.in).nextInt();
   }while((primero<0||primero>3)&&(segundo<0 ||segundo>3));
    }

}
