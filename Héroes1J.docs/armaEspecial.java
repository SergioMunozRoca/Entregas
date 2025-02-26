package EjercicioHeroe;

import com.sun.security.jgss.GSSUtil;

import java.util.ArrayList;
import java.util.Scanner;

public class armaEspecial {
    private String nombre;
    private int danyo;

    private static ArrayList<armaEspecial> arsenal = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public armaEspecial(String nombre, int danyo) {
        this.nombre = nombre;
        this.danyo = danyo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getDanyo() {
        return danyo;
    }

    public static void mostrarArmas(){
        System.out.println("******************");
        System.out.println("ARMAS DEL ARSENAL");
        System.out.println("******************");

        for (armaEspecial arma : arsenal){
            System.out.println(arma);
        }
    }

    public static void obtenerArma( ArrayList<armaEspecial> armasSeleccionadas){
        if (arsenal.isEmpty()){
            System.out.println("No hay armas en el arsenal.");
            return;
        }

        armaEspecial armaSeleccionada = null;

        mostrarArmas();
        System.out.println("..............................");
        System.out.println("Elige un arma por su nombre: ");
        String nombre = scanner.nextLine();

        for (armaEspecial arma : arsenal){
            if(arma.getNombre().equalsIgnoreCase(nombre)){
                armaSeleccionada = arma;
                System.out.println("Has elegido el arma: " + armaSeleccionada.getNombre());
                break;
            }
        }

        if(armaSeleccionada == null){
            System.out.println("Arma no encontrada. Elige un arma existente.");
            obtenerArma(armasSeleccionadas);
        }

        armasSeleccionadas.add(armaSeleccionada);

        System.out.println("Quieres elegir otra arma?(S/N): ");
        String respuesta = scanner.nextLine();

        if(respuesta.equalsIgnoreCase("S")){
            obtenerArma(armasSeleccionadas);
        }else{
            System.out.println("Has terminado de elegir armas.");

            System.out.println("Armas seleccionadas: ");
            for(armaEspecial arma : armasSeleccionadas){
                System.out.println(arma);

            }
        }
    }

    @Override
    public String toString() {
        return nombre + " (Daño: " + danyo + ")";
    }

    public static void agregarArma(armaEspecial nuevaArma){
        arsenal.add(nuevaArma);
    }
}
