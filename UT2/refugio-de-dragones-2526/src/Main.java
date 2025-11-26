public class Main {
    public static void main(String[] args) {
        // Crear el dragón Drogón, de 24 años y nivel de fuego 8
        Dragon dragon1 = new Dragon();
        dragon1.setNombre("Drogón");
        dragon1.setEdad(24);
        try {
            dragon1.setNivelFuego(8);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        // Crear el dragón Spyro, de 12 años y nivel de fuego 3
        try {
            Dragon dragon2 = new Dragon("Spyro", 12, 3333);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }
}
