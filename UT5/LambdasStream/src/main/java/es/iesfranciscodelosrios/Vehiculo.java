package es.iesfranciscodelosrios;
public class Vehiculo {
    private String modelo;
    private int velocidadMaxima;
    private int capacidadDeposito;
    private int anioFabricacion;

    // Constructor
    public Vehiculo(String modelo, int velocidadMaxima, int capacidadDeposito, int anioFabricacion) {
        this.modelo = modelo;
        this.velocidadMaxima = velocidadMaxima;
        this.capacidadDeposito = capacidadDeposito;
        this.anioFabricacion = anioFabricacion;
    }

    // Getters
    public String getModelo() {
        return modelo;
    }

    public int getVelocidadMaxima() {
        return velocidadMaxima;
    }

    public int getCapacidadDeposito() {
        return capacidadDeposito;
    }

    public int getAnioFabricacion() {
        return anioFabricacion;
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "modelo='" + modelo + '\'' +
                ", velocidadMaxima=" + velocidadMaxima +
                ", capacidadDeposito=" + capacidadDeposito +
                ", anioFabricacion=" + anioFabricacion +
                '}';
    }
}