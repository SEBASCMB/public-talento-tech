package servicios;

import interfaces.IInterfazUsuario;
import interfaces.IValidadorDatos;
import modelo.PanelSolar;
import modelo.ResultadoEnergia;
import java.util.Scanner;

public class InterfazUsuario implements IInterfazUsuario {
    
    private final Scanner scanner;
    private final IValidadorDatos validador;

    public InterfazUsuario(IValidadorDatos validador) {
        this.scanner = new Scanner(System.in);
        this.validador = validador;
    }
    
    @Override
    public PanelSolar capturarDatosPanelSolar() {
        mostrarMensaje("--Simulador Energía Solar--\n");
        
        double eficiencia = capturarEficiencia();
        double area = capturarArea();
        double radiacion = capturarRadiacion();
        
        return new PanelSolar(eficiencia, area, radiacion);
    }
    
    @Override
    public void mostrarResultados(PanelSolar panel, ResultadoEnergia resultado) {

        System.out.println("\n=== RESULTADOS DEL CÁLCULO ===");
        System.out.printf("Área Total: %.2f m²%n", panel.getArea());
        System.out.printf("Eficiencia del panel: %.2f%n", panel.getEficiencia());
        System.out.printf("Radiación promedio diaria: %.2f kWh/m²/día%n", panel.getRadiacion());
        System.out.printf("Energía generada estimada: %.2f kWh/día%n", resultado.getEnergiaGenerada());
        System.out.printf("Clasificación: %s%n", resultado.getClasificacion());
        System.out.println("================================");

    }
    
    @Override
    public void mostrarError(String mensaje) {
        System.err.println("ERROR: " + mensaje);
    }
    
    @Override
    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
    
    @Override
    public double solicitarDouble(String mensaje) {
        System.out.println(mensaje);
        return scanner.nextDouble();
    }

    private double capturarEficiencia() {
        double eficiencia;
        do {
            eficiencia = solicitarDouble("Ingrese la eficiencia del panel (0,10 a 0,25 - use comas como separador decimal):");
            if (!validador.validarEficiencia(eficiencia)) {
                mostrarError("Eficiencia fuera del rango válido (0,10 - 0,25). Intente nuevamente.");
            }
        } while (!validador.validarEficiencia(eficiencia));
        
        return eficiencia;
    }

    private double capturarArea() {
        double area;
        do {
            area = solicitarDouble("Ingrese el área del panel (5 a 50 m²):");
            if (!validador.validarArea(area)) {
                mostrarError("Área fuera del rango válido (5 - 50 m²). Intente nuevamente.");
            }
        } while (!validador.validarArea(area));
        
        return area;
    }

    private double capturarRadiacion() {
        double radiacion;
        do {
            radiacion = solicitarDouble("Ingrese la radiación del panel (3,5 a 6,5 kWh/m²/día - use comas como separador decimal):");
            if (!validador.validarRadiacion(radiacion)) {
                mostrarError("Radiación fuera del rango válido (3,5 - 6,5 kWh/m²/día). Intente nuevamente.");
            }
        } while (!validador.validarRadiacion(radiacion));
        
        return radiacion;
    }

    public void cerrar() {
        scanner.close();
    }
}