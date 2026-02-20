public class Orco extends Villano {
    public Orco(String nombre, int nivelMaldad) throws Exception {
        super(nombre, nivelMaldad);
        this.puntosVida = 110;
    }

    @Override
    public void atacar() {
        System.out.println("Aplasta a su enemigo con su maza!");
    }
}
