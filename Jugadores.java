import java.io.*;
import java.util.*;

public class Jugadores {

    public static void filtrarYGuardar(String archivoEntrada, String archivoSalida) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(archivoEntrada));
            BufferedWriter writer = new BufferedWriter(new FileWriter(archivoSalida));

            List<String> alojados = new ArrayList<>();
            reader.readLine();

            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(";");
                if (line.substring(line.length() - 3).contains("H")) {
                    alojados.add(line);
                }
            }
            reader.close();

            writer.write("Lista de jugadores alojados en Hotel Melià\n\n");
            writer.write("------------------------------------------\n\n");

            for (String jugador : alojados) {
                writer.write(jugador);
                writer.newLine();
            }
            writer.close();

            System.out.println("Archivo " + archivoSalida + " generado correctamente.");

        } catch (IOException e) {
            System.err.println("Error al manejar los archivos: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String archivoEntrada = "C:\\Users\\User\\Desktop\\ejemplo\\jugadores.txt";
        String archivoSalida = "C:\\Users\\User\\Desktop\\ejemplo\\alojadosHotel.txt";

        filtrarYGuardar(archivoEntrada, archivoSalida);
    }
}
