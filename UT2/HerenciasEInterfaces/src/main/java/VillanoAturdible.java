public abstract class VillanoAturdible extends Villano implements Aturdible{
    private boolean aturdido;
    public VillanoAturdible(String nombre, int nivelMaldad) throws Exception {
        super(nombre, nivelMaldad);
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
        if (this.aturdido) {
            anexo = " (Aturdido)";
        }
        return super.toString() + anexo;
    }
}
