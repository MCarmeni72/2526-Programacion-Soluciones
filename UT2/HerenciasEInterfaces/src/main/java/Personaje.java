public abstract class Personaje {
    private String nombre;
    protected int puntosVida;

    public Personaje(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void curarse(int puntos) {
        puntosVida += puntos;
    }

    public void herir(int puntos) {
        puntosVida -= puntos;
    }

    public int getPuntosVida() {
        return puntosVida;
    }

    public abstract void atacar();

    public abstract void presentar();

    @Override
    public String toString() {
        return "[" + this.getClass().getSimpleName() + "] " + this.getNombre() + " - " + this.getPuntosVida() + " PV";
    }
}
