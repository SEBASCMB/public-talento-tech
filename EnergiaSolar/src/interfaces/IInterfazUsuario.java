package interfaces;

import modelo.PanelSolar;
import modelo.ResultadoEnergia;

public interface IInterfazUsuario {
    
    PanelSolar capturarDatosPanelSolar();
    
    void mostrarResultados(PanelSolar panel, ResultadoEnergia resultado);
    
    void mostrarError(String mensaje);
    
    void mostrarMensaje(String mensaje);
    
    double solicitarDouble(String mensaje);
}