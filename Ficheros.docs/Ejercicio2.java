import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ejercicio2 {

    public static int obtenerSumaNumerosArchivo(String rutaArchivo) {
        int numero, suma = 0, cont = 0;
        File archivo = new File(rutaArchivo);
        Scanner entrada;
        try {
            entrada = new Scanner(archivo);
            while (entrada.hasNextInt()) {
                numero = entrada.nextInt();
                System.out.println(numero);
                suma = suma + numero;
                cont++;
            }
            System.out.println("Número leídos: " + cont);
            entrada.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return suma;
    }

    public static void main(String[] args) {
        String ruta = "C:\\Users\\User\\Desktop\\ejemplo\\numNaturales.txt";
        int suma = obtenerSumaNumerosArchivo(ruta);

        System.out.println("Suma: " + suma);
    }
}
