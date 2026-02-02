package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Tests unitarios para {@link CentroDeportivo} usando JUnit 5.
 */
class CentroDeportivoTest {

    private CentroDeportivo centro;

    @BeforeEach
    void setUp() {
        centro = new CentroDeportivo(3, 2); // 3 actividades, 2 socios
    }

    private Actividad actividad(String nombre) {
        return new Actividad(nombre, 60, "Básico", 10.0, 10);
    }

    private Socio socio(String nombre, String dni, int edad) {
        return new Socio(nombre, dni, edad);
    }

    // --------------------
    // Constructor / getters
    // --------------------

    @Test
    @DisplayName("Constructor inicializa arrays con las capacidades indicadas")
    void constructor_inicializaArrays() {
        assertNotNull(centro.getActividades());
        assertEquals(3, centro.getActividades().length);

        assertNotNull(centro.getSocios());
        assertEquals(2, centro.getSocios().length);
    }

    // --------------------
    // Actividades
    // --------------------

    @Test
    @DisplayName("existeActividad devuelve -1 si la actividad es null")
    void existeActividad_menosUno_siNull() {
        int pos = centro.existeActividad(null);
        assertEquals(-1, pos);
    }

    @Test
    @DisplayName("addActividad devuelve false si la actividad es null")
    void addActividad_false_siNull() {
        boolean ok = centro.addActividad(null);
        assertFalse(ok);
    }

    @Test
    @DisplayName("addActividad añade actividad si hay hueco y no está repetida")
    void addActividad_true_siInserta() {
        Actividad a1 = actividad("Yoga");

        boolean ok = centro.addActividad(a1);

        assertTrue(ok);
        assertEquals(0, centro.existeActividad(a1));
        assertSame(a1, centro.getActividades()[0]);
    }

    @Test
    @DisplayName("addActividad no permite duplicados (según equals de Actividad: nombre+nivel)")
    void addActividad_false_siDuplicada() {
        Actividad a1 = new Actividad("Yoga", 60, "Básico", 10.0, 10);
        Actividad a1Dup = new Actividad("Yoga", 30, "Básico", 99.0, 10);

        assertTrue(centro.addActividad(a1));

        boolean ok2 = centro.addActividad(a1Dup);

        assertFalse(ok2);
        assertEquals(0, centro.existeActividad(a1));
    }

    @Test
    @DisplayName("addActividad devuelve false si el array está completo")
    void addActividad_false_siCompleto() {
        assertTrue(centro.addActividad(actividad("A1")));
        assertTrue(centro.addActividad(actividad("A2")));
        assertTrue(centro.addActividad(actividad("A3")));

        boolean ok4 = centro.addActividad(actividad("A4"));

        assertFalse(ok4);
    }

    @Test
    @DisplayName("getActividad(String) devuelve null si no existe ese nombre")
    void getActividadPorNombre_null_siNoExiste() {
        Actividad a = centro.getActividad("NoExiste");
        assertNull(a);
    }

    @Test
    @DisplayName("getActividad(String) devuelve la actividad si existe el nombre")
    void getActividadPorNombre_devuelveActividad() {
        Actividad a1 = actividad("Yoga");
        Actividad a2 = actividad("Spinning");

        assertTrue(centro.addActividad(a1));
        assertTrue(centro.addActividad(a2));

        Actividad encontrada = centro.getActividad("Spinning");

        assertNotNull(encontrada);
        assertSame(a2, encontrada);
    }

    @Test
    @DisplayName("getActividad(int) devuelve null si el índice apunta a un hueco vacío")
    void getActividadPorId_null_siHuecoVacio() {
        Actividad encontrada = centro.getActividad(0);
        assertNull(encontrada);
    }

    @Test
    @DisplayName("getActividad(int) debería NO lanzar excepción si el id está fuera de rango (comportamiento seguro esperado)")
    void getActividadPorId_noDeberiaLanzar_excepcion_fueraDeRango() {
        // Este test define el comportamiento seguro esperado:
        // si piden un id inválido, debería devolver null y NO romper el programa.
        assertDoesNotThrow(() -> centro.getActividad(-1));
        assertNull(centro.getActividad(-1));

        assertDoesNotThrow(() -> centro.getActividad(999));
        assertNull(centro.getActividad(999));
    }

    // --------------------
    // Socios
    // --------------------

    @Test
    @DisplayName("existeSocio devuelve -1 si el socio es null")
    void existeSocio_menosUno_siNull() {
        int pos = centro.existeSocio(null);
        assertEquals(-1, pos);
    }

    @Test
    @DisplayName("addSocio devuelve false si el socio es null")
    void addSocio_false_siNull() {
        boolean ok = centro.addSocio(null);
        assertFalse(ok);
    }

    @Test
    @DisplayName("existeSocio devuelve la posición correcta cuando el socio está añadido (DEBE detectar bug actual)")
    void existeSocio_devuelvePosicion_siExiste() {
        Socio s1 = socio("Ana", "111A", 20);

        assertTrue(centro.addSocio(s1));

        // Comportamiento correcto esperado: está en la posición 0
        int pos = centro.existeSocio(s1);
        assertEquals(0, pos);
    }

    @Test
    @DisplayName("addSocio no permite duplicados por DNI (DEBE detectar bug derivado de existeSocio)")
    void addSocio_false_siDuplicadoPorDni() {
        Socio s1 = socio("Ana", "111A", 20);
        Socio s1Dup = socio("Otra", "111A", 99); // equals por DNI => duplicado lógico

        assertTrue(centro.addSocio(s1));

        boolean ok2 = centro.addSocio(s1Dup);

        // Comportamiento correcto esperado: NO debería permitir duplicado
        assertFalse(ok2);
        assertSame(s1, centro.getSocios()[0]);
        assertNull(centro.getSocios()[1]);
    }

    @Test
    @DisplayName("getSocio(String) devuelve el socio correcto si existe el DNI")
    void getSocioPorDni_devuelveSocio() {
        Socio s1 = socio("Ana", "111A", 20);
        Socio s2 = socio("Beto", "222B", 30);

        assertTrue(centro.addSocio(s1));
        assertTrue(centro.addSocio(s2));

        Socio encontrado = centro.getSocio("222B");

        assertNotNull(encontrado);
        assertSame(s2, encontrado);
    }

    @Test
    @DisplayName("getSocio(String) devuelve null si no existe el DNI")
    void getSocioPorDni_null_siNoExiste() {
        Socio encontrado = centro.getSocio("NOPE");
        assertNull(encontrado);
    }

    @Test
    @DisplayName("getSocio(int) devuelve el socio cuando el id es válido y hay socio en esa posición")
    void getSocioPorId_devuelveSocio_siExiste() {
        Socio s1 = socio("Ana", "111A", 20);

        assertTrue(centro.addSocio(s1)); // se inserta en [0]

        Socio encontrado = centro.getSocio(0);

        // Comportamiento correcto esperado: devuelve el mismo socio
        assertNotNull(encontrado);
        assertSame(s1, encontrado);
    }

    @Test
    @DisplayName("getSocio(int) debería NO lanzar excepción si el id está fuera de rango (comportamiento seguro esperado)")
    void getSocioPorId_noDeberiaLanzar_excepcion_fueraDeRango() {
        assertDoesNotThrow(() -> centro.getSocio(-1));
        assertNull(centro.getSocio(-1));

        assertDoesNotThrow(() -> centro.getSocio(999));
        assertNull(centro.getSocio(999));
    }

    @Test
    @DisplayName("addSocio devuelve false si el array de socios está completo")
    void addSocio_false_siCompleto() {
        assertTrue(centro.addSocio(socio("Ana", "111A", 20)));
        assertTrue(centro.addSocio(socio("Beto", "222B", 30)));

        boolean ok3 = centro.addSocio(socio("Carla", "333C", 40));

        assertFalse(ok3);
    }
}
