package interfaces;

import modelo.PanelSolar;
import modelo.ResultadoEnergia;

public interface ICalculadoraEnergia {
    
    ResultadoEnergia calcularEnergia(PanelSolar panel);
    
    double calcularEnergiaGenerada(double eficiencia, double area, double radiacion);
}