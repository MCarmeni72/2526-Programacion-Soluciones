public class Brujo extends VillanoAturdible implements LanzadorHechizos {
    public Brujo(String nombre, int nivelMaldad) throws Exception {
        super(nombre, nivelMaldad);
        this.puntosVida = 75;
    }

    @Override
    public void atacar() {
        System.out.println("¡Golpea con su vara a su rival!");
    }

    @Override
    public void lanzarHechizo() {
        System.out.println("¡Invoca energía oscura contra su rival!");
    }
}
