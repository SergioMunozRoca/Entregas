import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Ejercicio8 {

    public static void main(String[] args) {
        String nombreArchivo = "C:\\Users\\User\\Desktop\\ejemplo\\datos.txt";
        String palabra = "camion";
        int contador = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                contador += (linea.split(palabra, -1).length - 1);
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }

        System.out.println("La palabra '" + palabra + "' aparece " + contador + " veces en el archivo.");
    }
}