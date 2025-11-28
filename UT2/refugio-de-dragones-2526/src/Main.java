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
        Dragon dragon2 = null;
        Dragon dragon3 = null;
        Dragon dragon4 = null;
        try {
            dragon2 = new Dragon("Spyro", 12, 2);
            dragon3 = new Dragon("Drogón", 11, 3);
            dragon4 = new Dragon("Drogón", 24, 4);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        dragon1.lanzarLlamarada();
        System.out.println(dragon1);

        if (dragon1.equals(dragon2)) {
            System.out.println("dragon1 y dragon2 son iguales");
        } else {
            System.out.println("dragon1 y dragon2 son diferentes");
        }

        if (dragon1.equals(dragon3)) {
            System.out.println("dragon1 y dragon3 son iguales");
        } else {
            System.out.println("dragon1 y dragon3 son diferentes");
        }

        if (dragon1.equals(dragon4)) {
            System.out.println("dragon1 y dragon4 son iguales");
        } else {
            System.out.println("dragon1 y dragon4 son diferentes");
        }

        Guarida miGuarida = new Guarida(5);
        System.out.println("Capacidad: " + miGuarida.getCapacidad());
        System.out.println("Plazas libres: " + miGuarida.getPlazasDisponibles());
    }
}
