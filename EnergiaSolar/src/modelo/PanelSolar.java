package modelo;

public class PanelSolar {
    private final double eficiencia;
    private final double area;
    private final double radiacion;

    public PanelSolar(double eficiencia, double area, double radiacion) {
        this.eficiencia = eficiencia;
        this.area = area;
        this.radiacion = radiacion;
    }

    public double getEficiencia() {
        return eficiencia;
    }

    public double getArea() {
        return area;
    }

    public double getRadiacion() {
        return radiacion;
    }

    @Override
    public String toString() {
        return String.format("PanelSolar{eficiencia=%.2f, area=%.2f m², radiacion=%.2f kWh/m²/día}", 
                           eficiencia, area, radiacion);
    }
}