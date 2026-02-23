public class Bardo extends HeroeAturdible {

    public Bardo(String nombre, String mision) {
        super(nombre, mision);
        this.puntosVida = 80;
    }

    @Override
    public void atacar() {
        System.out.println("¡Entona una canción inspiradora que debilita al enemigo!");
    }

}
