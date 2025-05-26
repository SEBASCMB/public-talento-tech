package extensiones;

import interfaces.IClasificadorProduccion;

public class ClasificadorProduccionAvanzado implements IClasificadorProduccion {
    
    private static final double UMBRAL_MUY_BAJA  = 2.0;
    private static final double UMBRAL_BAJA      = 5.0;
    private static final double UMBRAL_MEDIA     = 10.0;
    private static final double UMBRAL_ALTA      = 15.0;
    private static final double UMBRAL_EXCELENTE = 20.0;
    
    private static final String CLASIFICACION_MUY_BAJA  = "Producción Muy Baja";
    private static final String CLASIFICACION_BAJA      = "Producción Baja";
    private static final String CLASIFICACION_MEDIA     = "Producción Media";
    private static final String CLASIFICACION_ALTA      = "Producción Alta";
    private static final String CLASIFICACION_MUY_ALTA  = "Producción Muy Alta";
    private static final String CLASIFICACION_EXCELENTE = "Producción Excelente";
    
    @Override
    public String clasificarProduccion(double energiaGenerada) {
        if (energiaGenerada < UMBRAL_MUY_BAJA) {
            return CLASIFICACION_MUY_BAJA;
        } else if (energiaGenerada < UMBRAL_BAJA) {
            return CLASIFICACION_BAJA;
        } else if (energiaGenerada <= UMBRAL_MEDIA) {
            return CLASIFICACION_MEDIA;
        } else if (energiaGenerada <= UMBRAL_ALTA) {
            return CLASIFICACION_ALTA;
        } else if (energiaGenerada <= UMBRAL_EXCELENTE) {
            return CLASIFICACION_MUY_ALTA;
        } else {
            return CLASIFICACION_EXCELENTE;
        }
    }
    
    @Override
    public double getUmbralProduccionMedia() {
        return UMBRAL_BAJA;
    }
    
    @Override
    public double getUmbralProduccionAlta() {
        return UMBRAL_MEDIA;
    }

    public String clasificarConRecomendaciones(double energiaGenerada) {
        String clasificacion = clasificarProduccion(energiaGenerada);
        String recomendacion = obtenerRecomendacion(energiaGenerada);
        return clasificacion + " - " + recomendacion;
    }

    public String obtenerRecomendacion(double energiaGenerada) {
        if (energiaGenerada < UMBRAL_MUY_BAJA) {
            return "Considere revisar la instalación y orientación del panel";
        } else if (energiaGenerada < UMBRAL_BAJA) {
            return "Evalúe mejoras en la eficiencia del sistema";
        } else if (energiaGenerada <= UMBRAL_MEDIA) {
            return "Producción aceptable para uso residencial básico";
        } else if (energiaGenerada <= UMBRAL_ALTA) {
            return "Excelente para autoconsumo residencial";
        } else if (energiaGenerada <= UMBRAL_EXCELENTE) {
            return "Ideal para autoconsumo con excedentes para venta";
        } else {
            return "Producción óptima para instalación comercial";
        }
    }

    public double calcularAhorroAnualEstimado(double energiaGenerada, double tarifaElectrica) {
        double energiaAnual = energiaGenerada * 365;
        return energiaAnual * tarifaElectrica;
    }

    public String evaluarImpactoAmbiental(double energiaGenerada) {
        double co2Evitado = energiaGenerada * 365 * 0.5; // kg CO2/año evitado
        
        if (co2Evitado < 500) {
            return String.format("Impacto Ambiental Básico: %.1f kg CO2/año evitado", co2Evitado);
        } else if (co2Evitado < 1500) {
            return String.format("Impacto Ambiental Bueno: %.1f kg CO2/año evitado", co2Evitado);
        } else if (co2Evitado < 3000) {
            return String.format("Impacto Ambiental Excelente: %.1f kg CO2/año evitado", co2Evitado);
        } else {
            return String.format("Impacto Ambiental Excepcional: %.1f kg CO2/año evitado", co2Evitado);
        }
    }
}