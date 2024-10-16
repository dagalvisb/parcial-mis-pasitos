import java.util.ArrayList;

public class Nivel{
    
    final double VALOR_TRANSPORTE = 400000;

    String nombre;
    double valorBase;
    int edadMinima;
    int edadMaxima;
    ArrayList<Nino> estudiantes;

    public double getVALOR_TRANSPORTE() {
        return VALOR_TRANSPORTE;
    }

    public String getNombre() {
        return nombre;
    }

    public double getValorBase() {
        return valorBase;
    }

    public int getEdadMinima() {
        return edadMinima;
    }

    public int getEdadMaxima() {
        return edadMaxima;
    }

    public ArrayList<Nino> getEstudiantes() {
        return estudiantes;
    }

    public  Nivel(String nombre, double valorBase, int edadMinima, int edadMaxima){
        this.nombre = nombre;
        this.valorBase = valorBase;
        this.edadMinima = edadMinima;
        this.edadMaxima = edadMaxima;
        this.estudiantes = new ArrayList<>();
    }

    public ArrayList<Nino> obtenerEstudiantes(){
        return this.estudiantes;
    }
}