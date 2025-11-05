public class TablaMultiplicarEj14 {
    public static void main(String[] args) {
        int numero =9;
        escribeTabla(numero);
    }

    public static void escribeTabla(int numero){
        for(int i=1;i<=10;i++){
            System.out.println(i+" * "+numero+" = "+i*numero);
        }
    }
}
