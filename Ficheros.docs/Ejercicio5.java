import java.io.*;
import java.util.*;

public class Ejercicio5 {

    public static void ordenarYGuardar(String archivoEntrada, String archivoSalida) {
        try {

            BufferedReader reader = new BufferedReader(new FileReader(archivoEntrada));
            String line;
            List<String> palabras = new ArrayList<>();


            while ((line = reader.readLine()) != null) {
                String[] palabrasLinea = line.split("\\s+");
                Collections.addAll(palabras, palabrasLinea);
            }
            reader.close();

            Collections.sort(palabras);

            BufferedWriter writer = new BufferedWriter(new FileWriter(archivoSalida));
            for (String palabra : palabras) {
                writer.write(palabra);
                writer.newLine();
            }
            writer.close();

            System.out.println("Las palabras han sido ordenadas y guardadas en " + archivoSalida);

        } catch (IOException e) {
            System.err.println("Error al manejar los archivos: " + e.getMessage());
        }
    }

    public static void main(String[] args) {

        String archivoEntrada = "C:\\Users\\User\\Desktop\\ejemplo\\datos.txt";
        String archivoSalida = "C:\\Users\\User\\Desktop\\ejemplo\\cadenaOrdenada.txt";

        ordenarYGuardar(archivoEntrada, archivoSalida);
    }
}
