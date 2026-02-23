public abstract class HeroeAturdible extends Heroe implements Aturdible {
    private boolean aturdido;
    public HeroeAturdible(String nombre, String mision) {
        super(nombre, mision);
        this.aturdido = false;
    }
    @Override
    public void aturdir() {
        aturdido = true;
    }

    @Override
    public boolean estaAturdido() {
        return aturdido;
    }

    @Override
    public void despertar() {
        aturdido = false;
    }

    @Override
    public String toString() {
        String anexo = "";
        if (this.estaAturdido()) {
            anexo = " (Aturdido)";
        }
        return super.toString() + anexo;
    }
}
