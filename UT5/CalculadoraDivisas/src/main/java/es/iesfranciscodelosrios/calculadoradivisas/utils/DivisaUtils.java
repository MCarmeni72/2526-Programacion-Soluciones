package es.iesfranciscodelosrios.calculadoradivisas.utils;

public class DivisaUtils {
    public static double convertirADivisa(double cantidad, Divisa divisa) {
        return cantidad * obtenerTipoCambio(divisa);
    }

    public static double convertirAEuros(double cantidad, Divisa divisa) {
        return cantidad / obtenerTipoCambio(divisa);
    }

    private static double obtenerTipoCambio(Divisa divisa) {
        final double CAMBIO_DOLAR = 1.18;
        final double CAMBIO_RUBLO = 88.93;
        final double CAMBIO_YUAN = 8.02;
        double tipoCambio = 0;
        switch (divisa) {
            case DOLAR:
                tipoCambio = CAMBIO_DOLAR;
                break;
            case RUBLO:
                tipoCambio = CAMBIO_RUBLO;
                break;
            case YUAN:
                tipoCambio = CAMBIO_YUAN;
                break;
        }
        return tipoCambio;
    }

    public static String formatearCantidad(double cantidad) {
        return String.format("%.2f", cantidad);
    }
}
