package model;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SocioTest {

    private Socio socio;

    @BeforeEach
    void setUp() {
        socio = new Socio("Ana", "111A", 20);
    }

    private Actividad actividad(String nombre, double precio) {
        return new Actividad(nombre, 60, "Básico", precio, 10);
    }

    @Test
    @DisplayName("Constructor inicializa campos y arrays (actividades=5, cuotas=12, pagadas=12)")
    void constructor_inicializaCamposYArrays() {
        assertEquals("Ana", socio.getNombre());
        assertEquals("111A", socio.getDni());
        assertEquals(20, socio.getEdad());

        assertNotNull(socio.getActividadesInscritas());
        assertEquals(5, socio.getActividadesInscritas().length);

        assertNotNull(socio.getCoutasMensuales());
        assertEquals(12, socio.getCoutasMensuales().length);

        assertNotNull(socio.getCoutasPagadas());
        assertEquals(12, socio.getCoutasPagadas().length);
    }

    @Test
    @DisplayName("Setters y getters actualizan correctamente nombre, dni y edad")
    void settersYGetters_funcionan() {
        socio.setNombre("Luis");
        socio.setDni("999Z");
        socio.setEdad(35);

        assertEquals("Luis", socio.getNombre());
        assertEquals("999Z", socio.getDni());
        assertEquals(35, socio.getEdad());
    }

    @Test
    @DisplayName("equals: true si DNI coincide (aunque cambien otros campos)")
    void equals_true_siDniCoincide() {
        Socio s1 = new Socio("Ana", "ABC123", 20);
        Socio s2 = new Socio("Otra", "ABC123", 99);

        assertEquals(s1, s2);
    }

    @Test
    @DisplayName("equals: false si DNI difiere")
    void equals_false_siDniDifiere() {
        Socio s1 = new Socio("Ana", "ABC123", 20);
        Socio s2 = new Socio("Ana", "XYZ999", 20);

        assertNotEquals(s1, s2);
    }

    @Test
    @DisplayName("toString contiene campos clave (nombre, dni, edad)")
    void toString_contieneCamposClave() {
        String s = socio.toString();

        assertTrue(s.contains("Socio{"));
        assertTrue(s.contains("nombre='Ana'"));
        assertTrue(s.contains("dni='111A'"));
        assertTrue(s.contains("edad=20"));
    }

    @Test
    @DisplayName("existeActividad devuelve -1 si la actividad es null")
    void existeActividad_devuelveMenosUno_siActividadNull() {
        int pos = socio.existeActividad(null);
        assertEquals(-1, pos);
    }

    @Test
    @DisplayName("existeActividad devuelve -1 si la actividad no está inscrita")
    void existeActividad_devuelveMenosUno_siNoExiste() {
        Actividad a = actividad("Yoga", 10.0);

        int pos = socio.existeActividad(a);

        assertEquals(-1, pos);
    }

    @Test
    @DisplayName("addActividad devuelve false si la actividad es null")
    void addActividad_false_siActividadNull() {
        boolean ok = socio.addActividad(null);

        assertFalse(ok);
        assertEquals(-1, socio.existeActividad(null));
    }

    @Test
    @DisplayName("addActividad añade una actividad si hay hueco y no está repetida")
    void addActividad_true_siHayHuecoYNoRepetida() {
        Actividad a1 = actividad("Yoga", 10.0);

        boolean ok = socio.addActividad(a1);

        assertTrue(ok);
        assertEquals(0, socio.existeActividad(a1));
        assertSame(a1, socio.getActividadesInscritas()[0]);
    }

    @Test
    @DisplayName("addActividad no permite duplicados (según equals de Actividad: nombre+nivel)")
    void addActividad_false_siDuplicada() {
        Actividad a1 = new Actividad("Yoga", 60, "Básico", 10.0, 10);
        Actividad a1Dup = new Actividad("Yoga", 30, "Básico", 99.0, 10); // equals debería dar true

        boolean ok1 = socio.addActividad(a1);
        assertTrue(ok1);

        boolean ok2 = socio.addActividad(a1Dup);
        assertFalse(ok2);

        assertEquals(1, countActividadesNoNulas(socio.getActividadesInscritas()));
    }

    @Test
    @DisplayName("addActividad devuelve false cuando está completo (MAX_ACTIVIDADES=5)")
    void addActividad_false_siCompleto() {
        Actividad a1 = actividad("A1", 1.0);
        Actividad a2 = actividad("A2", 1.0);
        Actividad a3 = actividad("A3", 1.0);
        Actividad a4 = actividad("A4", 1.0);
        Actividad a5 = actividad("A5", 1.0);
        Actividad a6 = actividad("A6", 1.0);

        assertTrue(socio.addActividad(a1));
        assertTrue(socio.addActividad(a2));
        assertTrue(socio.addActividad(a3));
        assertTrue(socio.addActividad(a4));
        assertTrue(socio.addActividad(a5));

        assertEquals(5, countActividadesNoNulas(socio.getActividadesInscritas()));

        boolean ok6 = socio.addActividad(a6);
        assertFalse(ok6);
        assertEquals(-1, socio.existeActividad(a6));
        assertEquals(5, countActividadesNoNulas(socio.getActividadesInscritas()));
    }

    @Test
    @DisplayName("removeActividad devuelve false si la actividad no existe")
    void removeActividad_false_siNoExiste() {
        Actividad a1 = actividad("Yoga", 10.0);

        boolean ok = socio.removeActividad(a1);

        assertFalse(ok);
        assertEquals(-1, socio.existeActividad(a1));
    }

    @Test
    @DisplayName("removeActividad elimina una actividad existente y deja null en su posición")
    void removeActividad_true_yElimina_siExiste() {
        Actividad a1 = actividad("Yoga", 10.0);

        assertTrue(socio.addActividad(a1));
        assertEquals(0, socio.existeActividad(a1));

        boolean removed = socio.removeActividad(a1);

        assertTrue(removed);
        assertEquals(-1, socio.existeActividad(a1));
        assertNull(socio.getActividadesInscritas()[0]);
    }

    @Test
    @DisplayName("recalcularCoutasDesdeMesActual recalcula desde mes actual con suma de precios de actividades")
    void recalcularCoutasDesdeMesActual_recalculaDesdeMesActual() {
        // Arrange: dos actividades -> cuota mensual actual = 10 + 15 = 25
        Actividad a1 = actividad("Yoga", 10.0);
        Actividad a2 = actividad("Spinning", 15.0);

        assertTrue(socio.addActividad(a1));
        assertTrue(socio.addActividad(a2));

        // Preconfigurar cuotas con un valor "sentinela" en TODOS los meses para detectar cambios.
        double[] cuotas = socio.getCoutasMensuales();
        for (int i = 0; i < cuotas.length; i++) {
            cuotas[i] = 99.99;
        }
        socio.setCoutasMensuales(cuotas);

        int mesActualIndex = LocalDate.now().getMonthValue() - 1; // 0..11

        // Act
        socio.recalcularCoutasDesdeMesActual();

        // Assert: meses anteriores NO cambian
        for (int i = 0; i < mesActualIndex; i++) {
            assertEquals(99.99, socio.getCoutasMensuales()[i], 0.0001);
        }

        // Assert: desde el mes actual hasta diciembre -> 25.0
        for (int i = mesActualIndex; i < 12; i++) {
            assertEquals(25.0, socio.getCoutasMensuales()[i], 0.0001);
        }
    }

    @Test
    @DisplayName("cambiarEstadoPagoMes: true y modifica el estado si mes es 1..12")
    void cambiarEstadoPagoMes_true_siMesValido() {
        boolean ok = socio.cambiarEstadoPagoMes(1, true);

        assertTrue(ok);
        assertTrue(socio.getCoutasPagadas()[0]);

        boolean ok2 = socio.cambiarEstadoPagoMes(12, false);
        assertTrue(ok2);
        assertFalse(socio.getCoutasPagadas()[11]);
    }

    @Test
    @DisplayName("cambiarEstadoPagoMes: false si mes es inválido")
    void cambiarEstadoPagoMes_false_siMesInvalido() {
        assertFalse(socio.cambiarEstadoPagoMes(0, true));
        assertFalse(socio.cambiarEstadoPagoMes(13, true));
        assertFalse(socio.cambiarEstadoPagoMes(-5, false));
    }

    @Test
    @DisplayName("getCuotaMes devuelve 0.0 si el mes es inválido")
    void getCuotaMes_cero_siMesInvalido() {
        assertEquals(0.0, socio.getCuotaMes(0), 0.0001);
        assertEquals(0.0, socio.getCuotaMes(13), 0.0001);
    }

    @Test
    @DisplayName("getCuotaMes devuelve la cuota correcta para un mes válido (1..12)")
    void getCuotaMes_devuelveValorCorrecto() {
        double[] cuotas = socio.getCoutasMensuales();
        cuotas[0] = 10.0;  // enero
        cuotas[4] = 50.0;  // mayo
        socio.setCoutasMensuales(cuotas);

        assertEquals(10.0, socio.getCuotaMes(1), 0.0001);
        assertEquals(50.0, socio.getCuotaMes(5), 0.0001);
    }

    @Test
    @DisplayName("getEstadoPagoMes devuelve 'Mes inválido' si el mes es inválido")
    void getEstadoPagoMes_mesInvalido() {
        assertEquals("Mes inválido", socio.getEstadoPagoMes(0));
        assertEquals("Mes inválido", socio.getEstadoPagoMes(13));
    }

    @Test
    @DisplayName("getEstadoPagoMes devuelve 'Pagado' o 'Pendiente' según el estado")
    void getEstadoPagoMes_pagadoPendiente() {
        socio.cambiarEstadoPagoMes(2, true);  // febrero
        socio.cambiarEstadoPagoMes(3, false); // marzo

        assertEquals("Pagado", socio.getEstadoPagoMes(2));
        assertEquals("Pendiente", socio.getEstadoPagoMes(3));
    }

    @Test
    @DisplayName("getTotalPagadoAnual suma solo meses pagados")
    void getTotalPagadoAnual_sumaMesesPagados() {
        double[] cuotas = socio.getCoutasMensuales();
        for (int i = 0; i < cuotas.length; i++) {
            cuotas[i] = 10.0;
        }
        socio.setCoutasMensuales(cuotas);

        // pagamos enero (1) y marzo (3)
        socio.cambiarEstadoPagoMes(1, true);
        socio.cambiarEstadoPagoMes(3, true);

        double total = socio.getTotalPagadoAnual();

        assertEquals(20.0, total, 0.0001);
    }

    @Test
    @DisplayName("getTotalPendienteAnual suma solo meses pendientes")
    void getTotalPendienteAnual_sumaMesesPendientes() {
        double[] cuotas = socio.getCoutasMensuales();
        for (int i = 0; i < cuotas.length; i++) {
            cuotas[i] = 5.0;
        }
        socio.setCoutasMensuales(cuotas);

        // pagamos 2 meses: enero y febrero
        socio.cambiarEstadoPagoMes(1, true);
        socio.cambiarEstadoPagoMes(2, true);

        double pendiente = socio.getTotalPendienteAnual();

        // 12 meses * 5 = 60, pagado 2*5 = 10, pendiente 50
        assertEquals(50.0, pendiente, 0.0001);
    }

    @Test
    @DisplayName("getMesesPendientesArray devuelve todos los meses 1..12 si ninguno está pagado")
    void getMesesPendientesArray_todosSiNingunoPagado() {
        int[] pendientes = socio.getMesesPendientesArray();

        assertNotNull(pendientes);
        assertEquals(12, pendientes.length);
        assertEquals(1, pendientes[0]);
        assertEquals(12, pendientes[11]);
    }

    @Test
    @DisplayName("getMesesPagadosArray devuelve array vacío si ninguno está pagado")
    void getMesesPagadosArray_vacioSiNingunoPagado() {
        int[] pagados = socio.getMesesPagadosArray();

        assertNotNull(pagados);
        assertEquals(0, pagados.length);
    }

    @Test
    @DisplayName("getMesesPagadosArray devuelve meses correctos cuando algunos están pagados")
    void getMesesPagadosArray_devuelveCorrectos() {
        socio.cambiarEstadoPagoMes(1, true);
        socio.cambiarEstadoPagoMes(5, true);
        socio.cambiarEstadoPagoMes(12, true);

        int[] pagados = socio.getMesesPagadosArray();

        assertEquals(3, pagados.length);
        assertEquals(1, pagados[0]);
        assertEquals(5, pagados[1]);
        assertEquals(12, pagados[2]);
    }

    @Test
    @DisplayName("getMesesPendientesArray devuelve meses pendientes correctos cuando algunos están pagados")
    void getMesesPendientesArray_devuelveCorrectos() {
        // Pagamos enero y febrero, el resto pendientes
        socio.cambiarEstadoPagoMes(1, true);
        socio.cambiarEstadoPagoMes(2, true);

        int[] pendientes = socio.getMesesPendientesArray();

        assertEquals(10, pendientes.length);
        assertEquals(3, pendientes[0]);
        assertEquals(12, pendientes[9]);
    }

    // ---- helpers ----

    private int countActividadesNoNulas(Actividad[] actividades) {
        int count = 0;
        for (Actividad a : actividades) {
            if (a != null) {
                count++;
            }
        }
        return count;
    }
}
