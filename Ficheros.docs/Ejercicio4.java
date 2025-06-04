import java.io.*;
import java.util.Scanner;

public class Ejercicio4 {

    public static void escribirCadena(){
        Scanner sc = new Scanner(System.in);
        try {
            FileWriter fileWriter = new FileWriter("C:\\Users\\User\\Desktop\\ejemplo\\sinEspacios.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            System.out.println("Introduce texto. Para acabar introduce la cadena FIN:");
            String cadena;
            cadena = sc.nextLine();
            while (!cadena.equalsIgnoreCase("FIN")) {
                String cadenaModificada = cadena.replaceAll("\\s+", "").toUpperCase();
                bufferedWriter.write(cadenaModificada);
                bufferedWriter.newLine();
                cadena = sc.nextLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }

    public static void leerCadena(){
        try {
            FileReader fr = new FileReader("C:\\Users\\User\\Desktop\\ejemplo\\sinEspacios.txt");
            BufferedReader entrada = new BufferedReader(fr);
            int car = entrada.read();
            while (car != -1) {
                System.out.print((char) car);
                car = entrada.read();
            }
            fr.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        escribirCadena();
        leerCadena();
    }
}