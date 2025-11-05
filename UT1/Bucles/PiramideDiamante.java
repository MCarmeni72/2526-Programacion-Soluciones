public class PiramideDiamante {
    public static void main(String[] args) {
        int altura = 5;
        for(int i=1;i<=altura;i++){
            for(int j=1;j<=(altura-i);j++){
                System.out.print(" ");
            }
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }
            for(int j=1;j<=(i-1);j++){
                System.out.print("*");
            }
            System.out.println();
        }
        for(int i=1;i<=(altura-1);i++){
            for(int j=1;j<=i;j++){
                System.out.print(" ");
            }
            for(int j=1;j<=(altura-i);j++){
                System.out.print("*");
            }
            for(int j=1;j<=(altura-i-1);j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
