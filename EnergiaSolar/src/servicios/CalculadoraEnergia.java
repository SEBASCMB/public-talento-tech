package servicios;

import interfaces.ICalculadoraEnergia;
import interfaces.IClasificadorProduccion;
import modelo.PanelSolar;
import modelo.ResultadoEnergia;

public class CalculadoraEnergia implements ICalculadoraEnergia {
    
    private final IClasificadorProduccion clasificador;

    public CalculadoraEnergia(IClasificadorProduccion clasificador) {
        this.clasificador = clasificador;
    }
    
    @Override
    public ResultadoEnergia calcularEnergia(PanelSolar panel) {
        double energiaGenerada = calcularEnergiaGenerada(
            panel.getEficiencia(), 
            panel.getArea(), 
            panel.getRadiacion()
        );
        
        String clasificacion = clasificador.clasificarProduccion(energiaGenerada);
        
        return new ResultadoEnergia(energiaGenerada, clasificacion);
    }
    
    @Override
    public double calcularEnergiaGenerada(double eficiencia, double area, double radiacion) {
        // Fórmula: Energía = Eficiencia × Área × Radiación
        return eficiencia * area * radiacion;
    }

    public double calcularEnergiaAnual(PanelSolar panel) {
        double energiaDiaria = calcularEnergiaGenerada(
            panel.getEficiencia(), 
            panel.getArea(), 
            panel.getRadiacion()
        );
        return energiaDiaria * 365;
    }

    public double calcularEnergiaReal(PanelSolar panel, double factorPerdidas) {
        double energiaIdeal = calcularEnergiaGenerada(
            panel.getEficiencia(), 
            panel.getArea(), 
            panel.getRadiacion()
        );
        return energiaIdeal * (1 - factorPerdidas);
    }
}