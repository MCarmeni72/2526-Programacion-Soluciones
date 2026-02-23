public class Main {
    static void main() {
        Personaje[] personajes = new Personaje[7];
        personajes[0] = new Bardo("Florencio", "Vengar a mi hermano");
        personajes[1]= new Guerrero("Hercules", "Ganar dinero");
        personajes[2]= new Mago("Hercules", "Aprender mucho");
        personajes[3] = new Paladin("Blatasar", "Conseguir el Santo Grial");
        try {
            personajes[4] = new Orco("Grok", 1);
            personajes[5] = new Brujo("Sarumón", 5);
            personajes[6] = new Goblin("Rizzo", 3);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        ((HeroeAturdible) personajes[0]).aturdir();
        for (Personaje personaje : personajes) {
            personaje.presentar();
            System.out.println(personaje);
            personaje.atacar();
            if (personaje instanceof LanzadorHechizos) {
                System.out.println("Puede lanzar un hechizo:");
                ((LanzadorHechizos) personaje).lanzarHechizo();
            }
            System.out.println("\n");
        }
    }
}
