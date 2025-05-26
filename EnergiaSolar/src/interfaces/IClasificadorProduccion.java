package interfaces;

public interface IClasificadorProduccion {
    
    String clasificarProduccion(double energiaGenerada);
    
    double getUmbralProduccionMedia();
    
    double getUmbralProduccionAlta();
}