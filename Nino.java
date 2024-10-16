public class Nino{
    String nombre;
    int edad;
    double totalMatricula;
    int cantotatHermanos;

    

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Nino(String nombre, int edad){
        this.nombre= nombre;
        this.edad= edad;
    }
    public double getTotalMatricula() {
        return totalMatricula;
    }
    public void setTotalMatricula(double totalMatricula) {
        this.totalMatricula = totalMatricula;
    }
    public int getCantotatHermanos() {
        return cantotatHermanos;
    }
    public void setCantotatHermanos(int cantotatHermanos) {
        this.cantotatHermanos = cantotatHermanos;
    } 
}