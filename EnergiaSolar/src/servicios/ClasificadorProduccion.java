package servicios;

import interfaces.IClasificadorProduccion;

public class ClasificadorProduccion implements IClasificadorProduccion {
    
    private static final double UMBRAL_PRODUCCION_BAJA = 5.0;
    private static final double UMBRAL_PRODUCCION_MEDIA = 10.0;
    
    private static final String CLASIFICACION_BAJA = "Producción Baja";
    private static final String CLASIFICACION_MEDIA = "Producción Media";
    private static final String CLASIFICACION_ALTA = "Producción Alta";
    
    @Override
    public String clasificarProduccion(double energiaGenerada) {
        if (energiaGenerada < UMBRAL_PRODUCCION_BAJA) {
            return CLASIFICACION_BAJA;
        } else if (energiaGenerada <= UMBRAL_PRODUCCION_MEDIA) {
            return CLASIFICACION_MEDIA;
        } else {
            return CLASIFICACION_ALTA;
        }
    }
    
    @Override
    public double getUmbralProduccionMedia() {
        return UMBRAL_PRODUCCION_BAJA;
    }
    
    @Override
    public double getUmbralProduccionAlta() {
        return UMBRAL_PRODUCCION_MEDIA;
    }

    public String getDescripcionUmbrales() {
        return String.format(
            "Umbrales de clasificación:\n" +
            "- %s: < %.1f kWh/día\n" +
            "- %s: %.1f - %.1f kWh/día\n" +
            "- %s: > %.1f kWh/día",
            CLASIFICACION_BAJA, UMBRAL_PRODUCCION_BAJA,
            CLASIFICACION_MEDIA, UMBRAL_PRODUCCION_BAJA, UMBRAL_PRODUCCION_MEDIA,
            CLASIFICACION_ALTA, UMBRAL_PRODUCCION_MEDIA
        );
    }
}