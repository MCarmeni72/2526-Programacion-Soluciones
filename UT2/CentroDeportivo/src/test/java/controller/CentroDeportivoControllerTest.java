package controller;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import model.Actividad;
import model.CentroDeportivo;
import model.Socio;

/**
 * Tests unitarios para {@link CentroDeportivoController} con JUnit 5.
 */
class CentroDeportivoControllerTest {

    private CentroDeportivo centro;
    private CentroDeportivoController controller;

    @BeforeEach
    void setUp() {
        centro = new CentroDeportivo(5, 5);
        controller = new CentroDeportivoController(centro);
    }

    // Helpers
    private Actividad crearActividadYRegistrar(String nombre, String nivel, double precio) {
        boolean ok = controller.registrarActividad(nombre, 60, nivel, precio, 10);
        assertTrue(ok);
        Actividad a = controller.buscarActividadPorNombre(nombre);
        assertNotNull(a);
        return a;
    }

    private Socio crearSocioYRegistrar(String nombre, String dni, int edad) {
        boolean ok = controller.registrarSocio(nombre, dni, edad);
        assertTrue(ok);
        Socio s = controller.buscarSocioPorDni(dni);
        assertNotNull(s);
        return s;
    }

    private int countNoNull(Object[] arr) {
        int c = 0;
        if (arr != null) {
            for (Object o : arr) if (o != null) c++;
        }
        return c;
    }

    // ========= SOCIOS =========

    @Test
    @DisplayName("registrarSocio: registra un socio nuevo y permite buscarlo por DNI")
    void registrarSocio_registraYBuscaPorDni() {
        boolean ok = controller.registrarSocio("Ana", "111A", 20);
        assertTrue(ok);

        Socio encontrado = controller.buscarSocioPorDni("111A");
        assertNotNull(encontrado);
        assertEquals("Ana", encontrado.getNombre());
        assertEquals("111A", encontrado.getDni());
        assertEquals(20, encontrado.getEdad());
    }

    @Test
    @DisplayName("registrarSocio: no permite duplicados por DNI")
    void registrarSocio_noPermiteDuplicados() {
        assertTrue(controller.registrarSocio("Ana", "111A", 20));

        boolean ok2 = controller.registrarSocio("Otra", "111A", 99);

        assertFalse(ok2);
        assertEquals(1, countNoNull(controller.listarSocios()));
    }

    @Test
    @DisplayName("buscarSocioPorId: comportamiento esperado: devuelve null para id fuera de rango (seguro)")
    void buscarSocioPorId_fueraDeRango_deberiaSerSeguro() {
        // Este test define el comportamiento seguro esperado para el controlador
        // (si el modelo lanza excepción por índice, esto lo detecta).
        assertDoesNotThrow(() -> controller.buscarSocioPorId(-1));
        assertNull(controller.buscarSocioPorId(-1));

        assertDoesNotThrow(() -> controller.buscarSocioPorId(999));
        assertNull(controller.buscarSocioPorId(999));
    }

    @Test
    @DisplayName("eliminarSocio: debería permitir eliminar el socio en índice 0 (detecta bug por condición idSocio > 0)")
    void eliminarSocio_deberiaPermitirEliminarIndice0() {
        // Arrange: el primer socio suele quedar en el índice 0 del array
        crearSocioYRegistrar("Ana", "111A", 20);
        Socio s = controller.buscarSocioPorDni("111A");
        assertNotNull(s);

        // Act
        boolean eliminado = controller.eliminarSocio(0);

        // Assert (comportamiento correcto esperado)
        assertTrue(eliminado);
        assertNull(controller.buscarSocioPorDni("111A"));
    }

    @Test
    @DisplayName("eliminarSocio: elimina y además desinscribe al socio de todas las actividades")
    void eliminarSocio_desinscribeDeActividades() {
        // Arrange
        Socio s = crearSocioYRegistrar("Ana", "111A", 20);
        Actividad a = crearActividadYRegistrar("Yoga", "Básico", 10.0);

        // Inscripción usando el controlador (para mantener coherencia bidireccional)
        boolean inscrito = controller.inscribirSocioEnActividad(0, 0);
        assertTrue(inscrito);

        assertEquals(1, a.numSociosActividad());

        // Act
        boolean eliminado = controller.eliminarSocio(0);

        // Assert
        assertTrue(eliminado);
        assertEquals(0, a.numSociosActividad());
        assertEquals(-1, a.existeSocio(s));
    }

    // ========= ACTIVIDADES =========

    @Test
    @DisplayName("registrarActividad: registra actividad y permite buscarla por nombre")
    void registrarActividad_registraYBuscaPorNombre() {
        boolean ok = controller.registrarActividad("Spinning", 45, "Intermedio", 25.0, 10);
        assertTrue(ok);

        Actividad encontrada = controller.buscarActividadPorNombre("Spinning");
        assertNotNull(encontrada);
        assertEquals("Spinning", encontrada.getNombre());
        assertEquals("Intermedio", encontrada.getNivel());
        assertEquals(25.0, encontrada.getPrecioMensual(), 0.0001);
    }

    @Test
    @DisplayName("registrarActividad: no permite duplicado por (nombre+nivel) aunque cambien otros campos")
    void registrarActividad_noPermiteDuplicados_nombreNivel() {
        assertTrue(controller.registrarActividad("Yoga", 60, "Básico", 10.0, 10));

        boolean ok2 = controller.registrarActividad("Yoga", 30, "Básico", 99.0, 99);

        assertFalse(ok2);
        assertEquals(1, countNoNull(controller.listarActividades()));
    }

    @Test
    @DisplayName("buscarActividadPorId: comportamiento esperado: null para id fuera de rango (seguro)")
    void buscarActividadPorId_fueraDeRango_deberiaSerSeguro() {
        assertDoesNotThrow(() -> controller.buscarActividadPorId(-1));
        assertNull(controller.buscarActividadPorId(-1));

        assertDoesNotThrow(() -> controller.buscarActividadPorId(999));
        assertNull(controller.buscarActividadPorId(999));
    }

    @Test
    @DisplayName("eliminarActividad: debería permitir eliminar actividad en índice 0 (detecta bug por condición idActividad > 0)")
    void eliminarActividad_deberiaPermitirEliminarIndice0() {
        crearActividadYRegistrar("Yoga", "Básico", 10.0);

        boolean eliminado = controller.eliminarActividad(0);

        assertTrue(eliminado);
        assertNull(controller.buscarActividadPorNombre("Yoga"));
    }

    @Test
    @DisplayName("eliminarActividad: elimina y la quita de todos los socios, recalculando cuotas desde mes actual")
    void eliminarActividad_quitaDeSocios_yRecalculaCuotas() {
        // Arrange
        crearActividadYRegistrar("Yoga", "Básico", 10.0);
        crearActividadYRegistrar("Spinning", "Básico", 15.0);

        crearSocioYRegistrar("Ana", "111A", 20);

        // Inscribir al socio en las dos actividades (id 0 y 1)
        assertTrue(controller.inscribirSocioEnActividad(0, 0));
        assertTrue(controller.inscribirSocioEnActividad(0, 1));

        Socio socio = controller.buscarSocioPorDni("111A");
        assertNotNull(socio);

        // Forzamos recalcular y leemos la cuota del mes actual para comprobar cambios posteriores
        socio.recalcularCoutasDesdeMesActual();
        int mesActual = LocalDate.now().getMonthValue();
        double cuotaAntes = socio.getCuotaMes(mesActual);

        assertEquals(25.0, cuotaAntes, 0.0001);

        // Act: eliminar la actividad 1 (esto sí pasa la condición idActividad > 0)
        boolean eliminado = controller.eliminarActividad(1);

        // Assert: debe eliminar y recalcular (quedará solo Yoga => 10.0)
        assertTrue(eliminado);

        double cuotaDespues = socio.getCuotaMes(mesActual);
        assertEquals(10.0, cuotaDespues, 0.0001);
    }

    // ========= INSCRIPCIONES =========

    @Test
    @DisplayName("inscribirSocioEnActividad: false si socio o actividad no existe")
    void inscribir_false_siNoExisteSocioOActividad() {
        // No hay nada registrado
        assertFalse(controller.inscribirSocioEnActividad(0, 0));

        // Registramos solo socio
        crearSocioYRegistrar("Ana", "111A", 20);
        assertFalse(controller.inscribirSocioEnActividad(0, 0));

        // Registramos solo actividad en otro centro (aquí no aplica), así que basta con lo anterior
    }

    @Test
    @DisplayName("inscribirSocioEnActividad: inscribe en ambas direcciones y recalcula cuotas")
    void inscribir_inscribeBidireccional_yRecalculaCuotas() {
        // Arrange
        crearSocioYRegistrar("Ana", "111A", 20);
        crearActividadYRegistrar("Yoga", "Básico", 10.0);

        int mesActual = LocalDate.now().getMonthValue();

        // Act
        boolean ok = controller.inscribirSocioEnActividad(0, 0);

        // Assert
        assertTrue(ok);

        Socio socio = controller.buscarSocioPorDni("111A");
        Actividad act = controller.buscarActividadPorNombre("Yoga");

        assertNotNull(socio);
        assertNotNull(act);

        assertEquals(0, socio.existeActividad(act));
        assertEquals(0, act.existeSocio(socio));

        assertEquals(10.0, socio.getCuotaMes(mesActual), 0.0001);
    }

    @Test
    @DisplayName("darDeBajaSocioDeActividad: da de baja en ambas direcciones y recalcula cuotas")
    void baja_desinscribeBidireccional_yRecalculaCuotas() {
        // Arrange
        crearSocioYRegistrar("Ana", "111A", 20);
        crearActividadYRegistrar("Yoga", "Básico", 10.0);

        int mesActual = LocalDate.now().getMonthValue();

        assertTrue(controller.inscribirSocioEnActividad(0, 0));
        Socio socio = controller.buscarSocioPorDni("111A");
        assertNotNull(socio);
        assertEquals(10.0, socio.getCuotaMes(mesActual), 0.0001);

        // Act
        boolean ok = controller.darDeBajaSocioDeActividad(0, 0);

        // Assert
        assertTrue(ok);

        Actividad act = controller.buscarActividadPorNombre("Yoga");
        assertNotNull(act);

        assertEquals(-1, socio.existeActividad(act));
        assertEquals(-1, act.existeSocio(socio));
        assertEquals(0.0, socio.getCuotaMes(mesActual), 0.0001);
    }

    // ========= CUOTAS =========

    @Test
    @DisplayName("obtenerEstadoPagoMes: devuelve 'Socio no encontrado' si idSocio inválido")
    void obtenerEstadoPagoMes_socioNoEncontrado() {
        String estado = controller.obtenerEstadoPagoMes(0, 1);
        assertEquals("Socio no encontrado", estado);
    }

    @Test
    @DisplayName("marcarCuotaPagada / marcarCuotaPendiente delegan correctamente en Socio")
    void marcarCuotas_funcionan() {
        crearSocioYRegistrar("Ana", "111A", 20);

        assertTrue(controller.marcarCuotaPagada(0, 1));
        assertEquals("Pagado", controller.obtenerEstadoPagoMes(0, 1));

        assertTrue(controller.marcarCuotaPendiente(0, 1));
        assertEquals("Pendiente", controller.obtenerEstadoPagoMes(0, 1));
    }

    // ========= INFORMES =========

    @Test
    @DisplayName("socioConMasActividades devuelve el socio correcto")
    void socioConMasActividades_devuelveCorrecto() {
        crearSocioYRegistrar("Ana", "111A", 20);
        crearSocioYRegistrar("Beto", "222B", 30);

        crearActividadYRegistrar("Yoga", "Básico", 10.0);
        crearActividadYRegistrar("Spinning", "Básico", 15.0);

        assertTrue(controller.inscribirSocioEnActividad(0, 0)); // Ana -> 1
        assertTrue(controller.inscribirSocioEnActividad(1, 0)); // Beto -> 1
        assertTrue(controller.inscribirSocioEnActividad(0, 1)); // Ana -> 2

        Socio max = controller.socioConMasActividades();

        assertNotNull(max);
        assertEquals("111A", max.getDni());
    }

    @Test
    @DisplayName("actividadMasPopular devuelve la actividad con más socios")
    void actividadMasPopular_devuelveCorrecta() {
        crearSocioYRegistrar("Ana", "111A", 20);
        crearSocioYRegistrar("Beto", "222B", 30);

        crearActividadYRegistrar("Yoga", "Básico", 10.0);
        crearActividadYRegistrar("Spinning", "Básico", 15.0);

        assertTrue(controller.inscribirSocioEnActividad(0, 0)); // Yoga: 1
        assertTrue(controller.inscribirSocioEnActividad(1, 0)); // Yoga: 2
        assertTrue(controller.inscribirSocioEnActividad(0, 1)); // Spinning: 1

        Actividad popular = controller.actividadMasPopular();

        assertNotNull(popular);
        assertEquals("Yoga", popular.getNombre());
    }
}
