package interfaces;

import modelo.PanelSolar;

public interface IValidadorDatos {
    
    boolean validarEficiencia(double eficiencia);
    
    boolean validarArea(double area);
    
    boolean validarRadiacion(double radiacion);
    
    boolean validarPanelSolar(double eficiencia, double area, double radiacion);
}