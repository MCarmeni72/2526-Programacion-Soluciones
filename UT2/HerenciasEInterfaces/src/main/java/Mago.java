public class Mago extends HeroeAturdible implements LanzadorHechizos {

    public Mago(String nombre, String mision) {
        super(nombre, mision);
        this.puntosVida = 70;
    }

    @Override
    public void atacar() {
        System.out.println("¡Propina un bastonazo!");
    }

    @Override
    public void lanzarHechizo() {
        System.out.println("¡Dispara una bola de fuego!");
    }

}
