package es.iesfranciscodelosrios;

public class PersonaFull {
        private String nombre;
        private int edad;
        private String ciudad;

        // Constructor
        public PersonaFull(String nombre, int edad, String ciudad) {
            this.nombre = nombre;
            this.edad = edad;
            this.ciudad = ciudad;
        }

        // Getters y Setters
        public String getNombre() {
            return nombre;
        }

        public int getEdad() {
            return edad;
        }

        public String getCiudad() {
            return ciudad;
        }

        @Override
        public String toString() {
            return nombre + ", " + edad + " años, " + ciudad;
        }
}
