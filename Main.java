import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Main{
    public static void main(String[] args){
        //
        DecimalFormat formater = new DecimalFormat("###,###.##");
        //
        ArrayList<Nivel> niveles = new ArrayList<>();

        Nivel nivel1 = new Nivel("Nivel 1", 4300000, 1, 2);
        Nivel nivel2 = new Nivel("Nivel 2", 3900000, 3, 4);
        Nivel nivel3 = new Nivel("Nivel 3", 3500000, 5, 5);

        niveles.add(nivel1);
        niveles.add(nivel2);
        niveles.add(nivel3);

        int deseaAñadirNuevoNino = JOptionPane.YES_OPTION;
        
        do{
            String nombre = JOptionPane.showInputDialog("Ingrese nombre del niño:");
            String edadTxt = JOptionPane.showInputDialog("Ingrese la edad de " + nombre + " :");
            int edad = Integer.parseInt(edadTxt);

            Nivel nivelAplicable = null;
            
            for (Nivel nivel : niveles){
                if(edad >= nivel.getEdadMinima() && edad <= nivel.getEdadMaxima()){
                    nivelAplicable = nivel;
                    break;
                }
            }

            if (nivelAplicable == null){
                JOptionPane.showMessageDialog(null, "No hay programa aplicable");
            }else{
                int deseaMatricular = JOptionPane.showConfirmDialog(null, "Le aplica el programa " + nivelAplicable.getNombre() + " con el valor " +  formater.format(nivelAplicable.getValorBase()), "¿Desea matricular el niño?", JOptionPane.YES_NO_OPTION);

                if (deseaMatricular == JOptionPane.YES_OPTION){

                    double sinDescuento = 0;
                    double descuento1Hermano = nivelAplicable.getValorBase() - (nivelAplicable.getValorBase() * 0.15);
                    String cantidadPorHErmanoTxt = JOptionPane.showInputDialog(null,"Cantidad hermanos matriculados:");
                    int cantidadPorHermano = Integer.parseInt(cantidadPorHErmanoTxt);
                    double cantidadHermanos = nivelAplicable.getValorBase()* ((cantidadPorHermano - 1) * 0.05);
                    double descuentoMasHrmanos = nivelAplicable.getValorBase() - ((nivelAplicable.getValorBase() * 0.15) + cantidadHermanos);
                    double totalDescuento = 0;

                    Nino niño = new Nino(nombre, edad);

                    nivelAplicable.obtenerEstudiantes().add(niño);

                    if (cantidadPorHermano == 1){
                        totalDescuento = descuento1Hermano;
                    }

                    if (cantidadPorHermano == 0){
                        totalDescuento = nivelAplicable.getValorBase() + sinDescuento;
                    }

                    if (cantidadPorHermano > 1){
                        totalDescuento = descuentoMasHrmanos;
                    }

                    JOptionPane.showMessageDialog(null, "Total con descuento por hermanos: " + formater.format(totalDescuento), "VALOR TOTAL", JOptionPane.INFORMATION_MESSAGE);

                    niño.setTotalMatricula(totalDescuento);
                    niño.setCantotatHermanos(cantidadPorHermano);
                }
            }
            
            deseaAñadirNuevoNino = JOptionPane.showConfirmDialog(null, "Desea añadir nuevo niño?", "continuar", JOptionPane.YES_NO_CANCEL_OPTION);
        }while (deseaAñadirNuevoNino == JOptionPane.YES_OPTION);

        

        String informacion = "";
        for (Nivel nivel : niveles) {
            informacion += "------------------------------------------------------------\n" + "Nombre del nivel: " + nivel.getNombre() + "\n";
            ArrayList<Nino> estudiantesPrograma = nivel.obtenerEstudiantes();

            if (nivel.obtenerEstudiantes().size() > 0){
                for (Nino niño : estudiantesPrograma){

                    double totalPorNino = nivel.getVALOR_TRANSPORTE();
                    informacion += String.format("------------------------------------------------------------\n" + "* %s (%d) Años\n -Base: $%s\n -Cantidad de hermanos: %d \n -Descuento por hermano: $%s \n  + Valor Transporte: $%s \n TOTAL A PAGAR: $%s \n", niño.getNombre(), niño.getEdad(), formater.format(nivel.getValorBase()),niño.getCantotatHermanos(),formater.format(niño.getTotalMatricula()),formater.format(nivel.getVALOR_TRANSPORTE()), formater.format(niño.getTotalMatricula() + totalPorNino));

                    
                }
            }else{
                informacion += "No hay estudiantes matriculados en este programa. \n ";
            }

        }
        JOptionPane.showMessageDialog(null, informacion);
    }
}