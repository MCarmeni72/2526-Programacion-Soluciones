public class Guerrero extends Heroe {

    public Guerrero(String nombre, String mision) {
        super(nombre, mision);
        this.puntosVida = 120;
    }

    @Override
    public void atacar() {
        System.out.println("¡Lanza un poderoso golpe con su espada!");
    }
}
