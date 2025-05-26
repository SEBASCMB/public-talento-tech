public class Emprendedor {

  private String nombre;
  private String documento;
  private String sector;
  private String ciudad;

  public Emprendedor(String nombre, String documento, String sector, String ciudad) {

    this.nombre    = nombre;
    this.documento = documento;
    this.sector    = sector;
    this.ciudad    = ciudad;

  }

  public String getNombre() {return nombre;}
  public String getDocumento() {return documento;}
  public String getSector() {return sector;}
  public String getCiudad() {return ciudad;}


}