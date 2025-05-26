import java.util.Scanner;

public class App {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Ingrese el nombre del Emprendedor: ");
    String nombre = sc.nextLine();

    System.out.print("Ingrese el número de Documento del Emprendedor: ");
    String documento = sc.nextLine();

    System.out.print("Ingrese el sector al que pertenece el Emprendedor: ");
    String sector = sc.nextLine();

    System.out.print("Ingrese la ciudad del Emprendedor: ");
    String ciudad = sc.nextLine();

    Emprendedor emprendedor = new Emprendedor(nombre, documento, sector, ciudad);

    EstadoProyecto estado = null;

    while (estado == null) {

      try {

        System.out.println("\nIngrese el estado del proyecto (EN_DISENIO, EN_MARCHA, CRECIMIENTO): ");
        String estadoTexto = sc.nextLine().toUpperCase();
        estado = EstadoProyecto.valueOf(estadoTexto);

      } catch (IllegalArgumentException e) {
        System.out.println("Estado inválido. Por favor, ingrese uno de los siguientes valores: EN_DISENIO, EN_MARCHA, CRECIMIENTO.");
      }

    }

    NivelInnovacion nivel = null;

    while (nivel == null) {

      try {

        System.out.println("\nIngrese el nivel de innovacion (BAJO, MEDIO, ALTO): ");
        String nivelTexto = sc.nextLine().toUpperCase();
        nivel = NivelInnovacion.valueOf(nivelTexto);

      } catch (IllegalArgumentException e) {
        System.out.println("Nivel de innovación inválido. Por favor, ingrese uno de los siguientes valores: BAJO, MEDIO, ALTO.");
      }

    }

    System.out.print("Ingrese el Nombre del proyecto: ");
    String nombreProyecto = sc.nextLine();

    System.out.print("Ingrese una breve descripcion del proyecto: ");
    String descripcion = sc.nextLine();

    Proyecto proyecto = new Proyecto(nombreProyecto, descripcion, nivel, estado, emprendedor);

    System.out.println("\n-------------------------");
    proyecto.mostrarResumen();

    EstadoProyecto nuevoEstadoEnum = null;
    while (nuevoEstadoEnum == null) {
      try {
        System.out.println("\nIngrese el nuevo estado del proyecto (EN_DISENIO, EN_MARCHA, CRECIMIENTO): ");
        String nuevoEstadoTexto = sc.nextLine().toUpperCase();
        nuevoEstadoEnum = EstadoProyecto.valueOf(nuevoEstadoTexto);
      } catch (IllegalArgumentException e) {
        System.out.println("Estado inválido. Por favor, ingrese uno de los siguientes valores: EN_DISENIO, EN_MARCHA, CRECIMIENTO.");
      }
    }
    proyecto.setEstado(nuevoEstadoEnum);

    NivelInnovacion nuevoNivelEnum = null;

    while (nuevoNivelEnum == null) {
      try {
        System.out.println("\nIngrese el nuevo nivel de innovacion (BAJO, MEDIO, ALTO): ");
        String nuevoNivelTexto = sc.nextLine().toUpperCase();
        nuevoNivelEnum = NivelInnovacion.valueOf(nuevoNivelTexto);
      } catch (IllegalArgumentException e) {
        System.out.println("Nivel de innovación inválido. Por favor, ingrese uno de los siguientes valores: BAJO, MEDIO, ALTO.");
      }
    }

    proyecto.setNivelInnovacion(nuevoNivelEnum);

    System.out.println("\n-------------------------");
    proyecto.mostrarResumen();

    sc.close();

  }
}
