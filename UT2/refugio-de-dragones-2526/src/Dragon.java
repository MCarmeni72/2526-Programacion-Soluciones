public class Dragon {
    private String nombre;
    private int edad;
    private int nivelFuego;

    public Dragon() {
        this.nombre = "Dragón desconocido";
        this.edad = 0;
        this.nivelFuego = 0;
    }

    public Dragon(String nombre, int edad, int nivelFuego) throws Exception {
        this.nombre = nombre;
        this.edad = edad;
        this.setNivelFuego(nivelFuego);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getNivelFuego() {
        return nivelFuego;
    }

    public void setNivelFuego(int nivelFuego) throws Exception {
        if (nivelFuego >= 0 && nivelFuego <= 10) {
            this.nivelFuego = nivelFuego;
        } else {
            throw new Exception("El nivel de fuego tiene que estar entre 0 y 10");
        }
    }

    public void lanzarLlamarada() {
        System.out.println("El dragón " + this.nombre + " ha lanzado una llamarada de nivel " + this.nivelFuego + ".");
    }

    @Override
    public String toString() {
        return "Dragón " + this.nombre + " (Edad: " + this.edad + ", nivelFuego: " + this.nivelFuego + ")";
    }

    @Override
    public boolean equals(Object obj) {
        boolean esIgual = false;

        if (this == obj) {
            esIgual = true;
        } else if (obj instanceof Dragon) {
            Dragon otroDragon = (Dragon) obj;
            if (this.nombre.equals(otroDragon.getNombre()) && this.edad == otroDragon.getEdad()) {
                esIgual = true;
            }
        }

        return esIgual;
    }
}
