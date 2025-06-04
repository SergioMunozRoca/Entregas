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
                String[] casillas = line.split(";");

                if (casillas.length >= 3) {
                    String primeraColumna = casillas[0];
                    String terceraColumna = casillas[2];
                    String septimaColumna = casillas[7];

                    if(septimaColumna.contains("H")){
                        alojados.add(primeraColumna + " - " + terceraColumna);
                    }
                }
            }
            reader.close();

            writer.write("Lista de jugadores alojados en Hotel Melià\n\n");
            writer.write("Ranking              Nombre\n");
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
