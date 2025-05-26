public class Proyecto {

  private final String nombre;
  private final String descripcion;
  private NivelInnovacion nivelInnovacion;
  private EstadoProyecto estado; // Removed final
  private final Emprendedor emprendedor;

  public Proyecto(String nombre, String descripcion, NivelInnovacion nivelInnovacion, EstadoProyecto estado, Emprendedor emprendedor) {

    this.nombre          = nombre;
    this.descripcion     = descripcion;
    this.nivelInnovacion = nivelInnovacion;
    this.estado          = estado;
    this.emprendedor     = emprendedor;

  }


  public EstadoProyecto getEstado() {
    return estado;
  }

  public void setEstado(EstadoProyecto estado) {

    if (estado == null) {
      throw new IllegalArgumentException("El estado no puede ser nulo.");
    }

    this.estado = estado;
  }

  public NivelInnovacion getNivelInnovacion() {
    return nivelInnovacion;
  }

  public void setNivelInnovacion(NivelInnovacion nivelInnovacion) {

    if (nivelInnovacion == null) {
      throw new IllegalArgumentException("El nivel de innovación no puede ser nulo.");
    }

    this.nivelInnovacion = nivelInnovacion;
  }

  public void mostrarResumen() {

    System.out.println("Registro exitoso\n");
    System.out.println(" Emprendedor ");
    System.out.println("\tNombre: " + emprendedor.getNombre());
    System.out.println("\tDocumento: " + emprendedor.getDocumento());
    System.out.println("\tSector: " + emprendedor.getSector());
    System.out.println("\tCiudad: " + emprendedor.getCiudad());
    System.out.println("\nProyecto");
    System.out.println("\tNombre: " + nombre);
    System.out.println("\tDescripcion: " + descripcion);
    System.out.println("\tNivel de innovacion: " + nivelInnovacion);
    System.out.println("\tEstado: " + estado);

  }
}

