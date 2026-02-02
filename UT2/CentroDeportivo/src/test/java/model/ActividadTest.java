package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Tests unitarios para {@link Actividad} usando JUnit 5 (Jupiter).
 */
class ActividadTest {

    private Actividad actividad;

    @BeforeEach
    void setUp() {
        // Capacidad fija (numMiembros) para probar add/remove/contador
        actividad = new Actividad("Spinning", 45, "Intermedio", 25.0, 2);
    }

    private Socio crearSocio(String dni, String nombre) {
        return new Socio(dni, nombre, 18); // La edad es obligatorio, pero no tiene importancia para nuestros tests.
    }

    @Test
    @DisplayName("Constructor inicializa campos básicos y crea array con la capacidad indicada")
    void constructor_inicializaCamposYArray() {
        assertEquals("Spinning", actividad.getNombre());
        assertEquals(45, actividad.getDuracionMinutos());
        assertEquals("Intermedio", actividad.getNivel());
        assertEquals(25.0, actividad.getPrecioMensual(), 0.0001);
        assertEquals(2, actividad.getNumMiembros());
        assertNotNull(actividad.getSociosActividad());
        assertEquals(2, actividad.getSociosActividad().length);
        assertEquals(0, actividad.numSociosActividad());
    }

    @Test
    @DisplayName("Setters y getters actualizan correctamente los valores")
    void settersYGetters_funcionan() {
        actividad.setNombre("Yoga");
        actividad.setDuracionMinutos(60);
        actividad.setNivel("Básico");
        actividad.setPrecioMensual(19.99);
        actividad.setNumMiembros(10);

        assertEquals("Yoga", actividad.getNombre());
        assertEquals(60, actividad.getDuracionMinutos());
        assertEquals("Básico", actividad.getNivel());
        assertEquals(19.99, actividad.getPrecioMensual(), 0.0001);
        assertEquals(10, actividad.getNumMiembros());
    }

    @Test
    @DisplayName("equals devuelve true si nombre y nivel coinciden (aunque cambien otros campos)")
    void equals_true_siNombreYNivelCoinciden() {
        Actividad a1 = new Actividad("Pilates", 50, "Avanzado", 30.0, 1);
        Actividad a2 = new Actividad("Pilates", 30, "Avanzado", 10.0, 5);

        assertEquals(a1, a2);
    }

    @Test
    @DisplayName("equals devuelve false si nombre difiere")
    void equals_false_siNombreDifiere() {
        Actividad a1 = new Actividad("Pilates", 50, "Avanzado", 30.0, 1);
        Actividad a2 = new Actividad("Yoga", 50, "Avanzado", 30.0, 1);

        assertNotEquals(a1, a2);
    }

    @Test
    @DisplayName("equals devuelve false si nivel difiere")
    void equals_false_siNivelDifiere() {
        Actividad a1 = new Actividad("Pilates", 50, "Avanzado", 30.0, 1);
        Actividad a2 = new Actividad("Pilates", 50, "Básico", 30.0, 1);

        assertNotEquals(a1, a2);
    }

    @Test
    @DisplayName("toString contiene campos clave (nombre, nivel, duración, precio, numMiembros)")
    void toString_contieneCamposClave() {
        String s = actividad.toString();

        assertTrue(s.contains("Actividad{"));
        assertTrue(s.contains("nombre='Spinning'"));
        assertTrue(s.contains("duracionMinutos=45"));
        assertTrue(s.contains("nivel='Intermedio'"));
        assertTrue(s.contains("precioMensual=25.0"));
        assertTrue(s.contains("numMiembros=2"));
    }

    @Test
    @DisplayName("existeSocio devuelve -1 si el socio es null")
    void existeSocio_devuelveMenosUno_siSocioNull() {
        int pos = actividad.existeSocio(null);
        assertEquals(-1, pos);
    }

    @Test
    @DisplayName("existeSocio devuelve -1 si el socio no está en el array")
    void existeSocio_devuelveMenosUno_siNoExiste() {
        Socio s1 = crearSocio("111A", "Ana");

        int pos = actividad.existeSocio(s1);

        assertEquals(-1, pos);
    }

    @Test
    @DisplayName("addSocio devuelve false si el socio es null")
    void addSocio_false_siSocioNull() {
        boolean ok = actividad.addSocio(null);
        assertFalse(ok);
        assertEquals(0, actividad.numSociosActividad());
    }

    @Test
    @DisplayName("addSocio añade un socio si hay hueco y no está repetido")
    void addSocio_true_ySeInserta_siHayHuecoYNoRepetido() {
        Socio s1 = crearSocio("111A", "Ana");

        boolean ok = actividad.addSocio(s1);

        assertTrue(ok);
        assertEquals(1, actividad.numSociosActividad());
        assertEquals(0, actividad.existeSocio(s1));
        assertSame(s1, actividad.getSociosActividad()[0]);
    }

    @Test
    @DisplayName("addSocio no permite duplicados (mismo socio según equals)")
    void addSocio_false_siDuplicado() {
        Socio s1 = crearSocio("111A", "Ana");
        Socio s1Duplicado = crearSocio("111A", "Ana"); // si equals de Socio compara por DNI, será duplicado

        boolean ok1 = actividad.addSocio(s1);
        assertTrue(ok1);

        boolean ok2 = actividad.addSocio(s1Duplicado);
        assertFalse(ok2);

        assertEquals(1, actividad.numSociosActividad());
    }

    @Test
    @DisplayName("addSocio devuelve false cuando la actividad está completa")
    void addSocio_false_siCompleta() {
        Socio s1 = crearSocio("111A", "Ana");
        Socio s2 = crearSocio("222B", "Beto");
        Socio s3 = crearSocio("333C", "Carla");

        boolean ok1 = actividad.addSocio(s1);
        assertTrue(ok1);
        boolean ok2 = actividad.addSocio(s2);
        assertTrue(ok2);

        assertEquals(2, actividad.numSociosActividad());

        boolean ok3 = actividad.addSocio(s3);
        assertFalse(ok3);

        assertEquals(2, actividad.numSociosActividad());
        assertEquals(-1, actividad.existeSocio(s3));
    }

    @Test
    @DisplayName("removeSocio devuelve false si el socio no existe")
    void removeSocio_false_siNoExiste() {
        Socio s1 = crearSocio("111A", "Ana");

        boolean ok = actividad.removeSocio(s1);

        assertFalse(ok);
        assertEquals(0, actividad.numSociosActividad());
    }

    @Test
    @DisplayName("removeSocio elimina un socio existente y libera su posición")
    void removeSocio_true_yElimina_siExiste() {
        Socio s1 = crearSocio("111A", "Ana");

        boolean added = actividad.addSocio(s1);
        assertTrue(added);
        assertEquals(1, actividad.numSociosActividad());

        boolean removed = actividad.removeSocio(s1);

        assertTrue(removed);
        assertEquals(0, actividad.numSociosActividad());
        assertEquals(-1, actividad.existeSocio(s1));
        assertNull(actividad.getSociosActividad()[0]);
    }

    @Test
    @DisplayName("numSociosActividad cuenta correctamente ignorando nulls")
    void numSociosActividad_cuentaCorrecto() {
        Socio s1 = crearSocio("111A", "Ana");
        Socio s2 = crearSocio("222B", "Beto");

        assertEquals(0, actividad.numSociosActividad());

        actividad.addSocio(s1);
        assertEquals(1, actividad.numSociosActividad());

        actividad.addSocio(s2);
        assertEquals(2, actividad.numSociosActividad());

        actividad.removeSocio(s1);
        assertEquals(1, actividad.numSociosActividad());

        actividad.removeSocio(s2);
        assertEquals(0, actividad.numSociosActividad());
    }

    @Test
    @DisplayName("getSociosActividad devuelve la referencia del array interno (no una copia)")
    void getSociosActividad_devuelveReferencia() {
        Socio[] ref1 = actividad.getSociosActividad();
        Socio[] ref2 = actividad.getSociosActividad();

        assertSame(ref1, ref2);
    }
}
