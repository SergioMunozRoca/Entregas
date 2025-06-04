import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Ejercicio7 {

    public static void mostrarArchivoPantalla(String nombreArchivo) {
        try (BufferedReader entrada = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = entrada.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    public static void main(String[] args) {

        String rutaArchivo = "C:\\Users\\User\\Desktop\\ejemplo\\datos.txt";
        mostrarArchivoPantalla(rutaArchivo);

    }
}
