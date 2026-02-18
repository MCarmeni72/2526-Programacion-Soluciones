public class CocheCombustion extends Vehiculo implements Sonido, Repostable{
    private double capacidadDeposito;

    public double getCapacidadDeposito() {
        return capacidadDeposito;
    }

    public void setCapacidadDeposito(double capacidadDeposito) {
        this.capacidadDeposito = capacidadDeposito;
    }

    @Override
    public void hacerSonido() {
        System.out.println("Brum brum");
    }

    @Override
    public void repostar() {
        capacidadDeposito += 10;
    }
}
