public class Goblin extends Villano {
    public Goblin(String nombre, int nivelMaldad) throws Exception {
        super(nombre, nivelMaldad);
        this.puntosVida = 60;
    }

    @Override
    public void atacar() {
        System.out.println("¡Ataca rápidamente desde las sombras!");
    }}
