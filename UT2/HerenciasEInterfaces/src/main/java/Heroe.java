public abstract class Heroe extends Personaje {
    private String mision;

    public Heroe(String nombre, String mision) {
        super(nombre);
        this.mision = mision;
    }

    public void setMision(String mision) {
        this.mision = mision;
    }

    public String getMision() {
        return mision;
    }

    @Override
    public void presentar() {
        System.out.println("Soy " + this.getNombre() + " y soy un " + this.getClass().getSimpleName() +
                " y mi misión es " + this.getMision());
    }
}



