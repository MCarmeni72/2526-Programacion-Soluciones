public abstract class Villano extends Personaje {

    private final int NIVELMALDAD;

    public Villano(String nombre, int nivelMaldad) throws Exception {
        super(nombre);
        if (nivelMaldad < 1 || nivelMaldad > 5) {
            throw new Exception("Nivel de maldad inválido");
        } else {
            this.NIVELMALDAD = nivelMaldad;
        }
    }

    public int getNivelMaldad() {
        return NIVELMALDAD;
    }

    @Override
    public void presentar() {
        System.out.println("Soy " + this.getNombre() + " y soy un " + this.getClass().getSimpleName() +
                " de nivel " + this.getNivelMaldad());
    }
}