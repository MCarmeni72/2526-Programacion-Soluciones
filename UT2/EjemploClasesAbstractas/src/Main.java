public class Main {
    static void main() {
        Animal miMascota = new Gato("Misifu");
        miMascota.setNombre("Fermín");
        Animal miOtraMascota = new Perro("Rufo");
        miMascota.hacerSonido();
        miOtraMascota.hacerSonido();
        // Array de la clase abstracta.
        Animal[] misMascotas = new Animal[2];
        misMascotas[0] = new Gato("Azrael");
        misMascotas[1] = new Perro("Fido");
        for (Animal animal : misMascotas) {
            animal.hacerSonido();
            animal.dormir();
        }

        CocheElectrico miCocheSilencioso = new CocheElectrico();
        CocheCombustion miCocheDiesel = new CocheCombustion();

        Sonido[] elementosSonoros = { miMascota, miCocheDiesel};
        for (Sonido elementoSonoro : elementosSonoros) {
            elementoSonoro.hacerSonido();
        }
    }

}
