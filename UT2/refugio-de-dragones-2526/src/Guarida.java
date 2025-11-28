public class Guarida {
    private int capacidad;
    private Dragon[] dragones;

    public Guarida() {
        this.capacidad = 10;
        this.dragones = new Dragon[capacidad];
    }
    public Guarida(int capacidad) {
        this.capacidad = capacidad;
        this.dragones = new Dragon[capacidad];
    }

    public int getCapacidad() {
        return capacidad;
    }

    public Dragon[] getDragones() {
        return dragones;
    }

    public int getPlazasDisponibles() {
        int plazasDisponibles = 0;

        for (Dragon dragon : dragones) {
            if (dragon == null) {
                plazasDisponibles++;
            }
        }

        return plazasDisponibles;
    }

    // addDragon
    // removeDragon

}
