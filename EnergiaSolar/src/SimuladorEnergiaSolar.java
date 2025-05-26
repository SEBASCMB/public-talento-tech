import interfaces.*;
import modelo.*;
import servicios.*;

public class SimuladorEnergiaSolar {

    private final IInterfazUsuario interfazUsuario;
    private final ICalculadoraEnergia calculadora;
    private final IValidadorDatos validador;

    public SimuladorEnergiaSolar(
        IInterfazUsuario interfazUsuario,
        ICalculadoraEnergia calculadora,
        IValidadorDatos validador
    ) {
        this.interfazUsuario = interfazUsuario;
        this.calculadora = calculadora;
        this.validador = validador;
    }

    public void ejecutarSimulacion() {
        try {
            PanelSolar panel = interfazUsuario.capturarDatosPanelSolar();

            ResultadoEnergia resultado = calculadora.calcularEnergia(panel);
            interfazUsuario.mostrarResultados(panel, resultado);
        } catch (Exception e) {
            interfazUsuario.mostrarError(
                "Error durante la simulación: " + e.getMessage()
            );
        }
    }

    public static void main(String[] args) {

        IValidadorDatos validador = new ValidadorDatos();
        IClasificadorProduccion clasificador = new ClasificadorProduccion();
        ICalculadoraEnergia calculadora = new CalculadoraEnergia(clasificador);
        IInterfazUsuario interfaz = new InterfazUsuario(validador);

        SimuladorEnergiaSolar simulador =
            new SimuladorEnergiaSolar(
                interfaz,
                calculadora,
                validador
            );

        simulador.ejecutarSimulacion();

        if (interfaz instanceof InterfazUsuario) {
            ((InterfazUsuario) interfaz).cerrar();
        }
    }

    public static SimuladorEnergiaSolar crearSimuladorPersonalizado(
        IInterfazUsuario interfaz,
        IClasificadorProduccion clasificador,
        IValidadorDatos validador
    ) {
        ICalculadoraEnergia calculadora = new CalculadoraEnergia(clasificador);
        return new SimuladorEnergiaSolar(
            interfaz,
            calculadora,
            validador
        );
    }
}
