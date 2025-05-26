import java.util.Scanner;

public class SimuladorEnergiaSolar {

    public static void main(String[] args) {
        System.out.println("--Simulador Energia Solar--");

        double[] valores = capturarDatos();

        double eficiencia = valores[0];
        double area = valores[1];
        double radiacion = valores[2];

        calcularYMostrarResultados(eficiencia, area, radiacion);
    }

    public static double[] capturarDatos(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese la eficiencia del panel (0,10 a 0,25 valores con comas):");
        double eficiencia = sc.nextDouble();

        if (eficiencia<0.1 || eficiencia>0.25){
            System.out.println("Eficiencia fuera del rango valido. Terminando programa...");
            System.exit(0);
        }

        System.out.println("Ingrese el area del panel (5 a 50):");
        double area = sc.nextDouble();

        if (area<5 || area>50){
            System.out.println("Area fuera del rango valido. Terminando programa...");
            System.exit(0);
        }

        System.out.println("Ingrese la radiación del panel (3,5 a 6,5 kWh valores con comas):");
        double radiacion = sc.nextDouble();

        if (radiacion<3.5 || radiacion>6.5){
            System.out.println("Radiacion fuera del rango valido. Terminando programa...");
            System.exit(0);
        }

        return new double[] {eficiencia, area, radiacion};
    }

    public static void calcularYMostrarResultados(double eficiencia, double area, double radiacion){
        double energiaGenerada =  eficiencia * area * radiacion;
        String clasificacion = "";

        if (energiaGenerada < 5) {
            clasificacion = "Producción Baja";
        } else if (energiaGenerada <= 10) {
            clasificacion = "Produccion Media";
        } else {
            clasificacion = "Produccion Alta";
        }

        System.out.print("\n Area Total: " + area + "m²");
        System.out.print("\n Eficiencia del panel: " + eficiencia);
        System.out.print("\n Radiacion promedio diaria: " + radiacion + "KWh/m²/día");
        System.out.printf("\n Energia generada estimada: %.2f KWh/día", energiaGenerada);
        System.out.print("\n Clasificación: " + clasificacion);

    }


}
