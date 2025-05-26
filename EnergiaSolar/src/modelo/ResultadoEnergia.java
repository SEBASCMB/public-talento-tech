package modelo;

public class ResultadoEnergia {
    private final double energiaGenerada;
    private final String clasificacion;

    public ResultadoEnergia(double energiaGenerada, String clasificacion) {
        this.energiaGenerada = energiaGenerada;
        this.clasificacion = clasificacion;
    }

    public double getEnergiaGenerada() {
        return energiaGenerada;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    @Override
    public String toString() {
        return String.format("ResultadoEnergia{energiaGenerada=%.2f kWh/día, clasificacion='%s'}", 
                           energiaGenerada, clasificacion);
    }
}