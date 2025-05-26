package servicios;

import interfaces.IValidadorDatos;

public class ValidadorDatos implements IValidadorDatos {
    
    private static final double EFICIENCIA_MIN = 0.10;
    private static final double EFICIENCIA_MAX = 0.25;
    private static final double AREA_MIN       = 5.0;
    private static final double AREA_MAX       = 50.0;
    private static final double RADIACION_MIN  = 3.5;
    private static final double RADIACION_MAX  = 6.5;
    
    @Override
    public boolean validarEficiencia(double eficiencia) {
        return eficiencia >= EFICIENCIA_MIN && eficiencia <= EFICIENCIA_MAX;
    }
    
    @Override
    public boolean validarArea(double area) {
        return area >= AREA_MIN && area <= AREA_MAX;
    }
    
    @Override
    public boolean validarRadiacion(double radiacion) {
        return radiacion >= RADIACION_MIN && radiacion <= RADIACION_MAX;
    }
    
    @Override
    public boolean validarPanelSolar(double eficiencia, double area, double radiacion) {
        return validarEficiencia(eficiencia) && 
               validarArea(area) && 
               validarRadiacion(radiacion);
    }

    public String getMensajeErrorEficiencia() {
        return String.format("Eficiencia fuera del rango válido (%.2f - %.2f)", 
                           EFICIENCIA_MIN, EFICIENCIA_MAX);
    }

    public String getMensajeErrorArea() {
        return String.format("Área fuera del rango válido (%.1f - %.1f m²)", 
                           AREA_MIN, AREA_MAX);
    }

    public String getMensajeErrorRadiacion() {
        return String.format("Radiación fuera del rango válido (%.1f - %.1f kWh/m²/día)", 
                           RADIACION_MIN, RADIACION_MAX);
    }
}