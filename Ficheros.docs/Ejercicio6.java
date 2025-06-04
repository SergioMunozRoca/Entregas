import java.io.*;
import java.nio.file.*;
import java.util.*;

public class Ejercicio6 {

    public static void contarVocalesConsonantesNumeros(String archivoEntrada) {
        int vocales = 0;
        int consonantes = 0;
        int numeros = 0;

        try {
            List<String> lineas = Files.readAllLines(Paths.get(archivoEntrada));

            for (String linea : lineas) {
                for (int i = 0; i < linea.length(); i++) {
                    char c = linea.charAt(i);

                    if (isVocal(c)) {
                        vocales++;
                    }else if (Character.isLetter(c)) {
                        consonantes++;
                    }else if (Character.isDigit(c)) {
                        numeros++;
                    }
                }
            }

            System.out.println("Vocales: " + vocales);
            System.out.println("Consonantes: " + consonantes);
            System.out.println("Números: " + numeros);

        } catch (IOException e) {
            System.err.println("Error al manejar el archivo: " + e.getMessage());
        }
    }

    public static boolean isVocal(char c) {
        c = Character.toLowerCase(c);
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    public static void main(String[] args) {

        String archivoEntrada = "C:\\Users\\User\\Desktop\\ejemplo\\datos.txt";

        contarVocalesConsonantesNumeros(archivoEntrada);
    }
}
