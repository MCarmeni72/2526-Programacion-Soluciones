import java.util.Scanner;

public class Pedir3NotasConFunciones {
    public static void main(String[] args) {
        double nota1=0, nota2=0, nota3=0;
        final double notaMinima = 0;
        final double notaMaxima = 10;
        nota1 = pideNumero(notaMinima,notaMaxima,"Introduce nota 1:","la nota introducida no es válida");
        nota2 = pideNumero(notaMinima,notaMaxima,"Introduce nota 2:","la nota introducida no es válida");
        nota3 = pideNumero(notaMinima,notaMaxima,"Introduce nota 3:","la nota introducida no es válida");
        System.out.println("Las notas introducidas son: "+nota1+", "+nota2+", "+nota3);
    }

    public static double pideNumero(double numeroMin, double numeroMax,String mensaje,String mensajeError){
        Scanner sc = new Scanner(System.in);
        double nota = 0;
        do {
            System.out.println(mensaje);
            nota = sc.nextDouble();
            if(nota<numeroMin||nota>numeroMax){
                System.out.println(mensajeError);
            }
        } while(nota<numeroMin||nota>numeroMax);
      return nota;
    }
}
