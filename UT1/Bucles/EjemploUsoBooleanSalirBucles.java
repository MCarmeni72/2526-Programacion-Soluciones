import java.util.Scanner;

//pedir numeros hasta que me ponga un 0.
public class EjemploUsoBooleanSalirBucles {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numero=1;
        boolean quieroSalir=false;
        while(!quieroSalir){
            System.out.println("Introduce Numero:");
            numero=sc.nextInt();
            if(numero==0){
                quieroSalir=true;
            }
        }
    }

}
