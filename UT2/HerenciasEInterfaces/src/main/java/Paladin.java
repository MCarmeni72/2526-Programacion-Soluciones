public class Paladin extends Heroe implements LanzadorHechizos{
    public Paladin(String nombre, String mision) {
        super(nombre, mision);
        this.puntosVida = 110;
    }

    @Override
    public void lanzarHechizo() {
        System.out.println("Cura al resto del equipo");
    }

    @Override
    public void atacar() {
        System.out.println("Blande su mandoble");
    }
}
