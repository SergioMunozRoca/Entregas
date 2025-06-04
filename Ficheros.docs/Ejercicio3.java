import java.io.*;
import java.util.Scanner;

public class Ejercicio3 {

    public static boolean esPrimo(int num) {

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void escribirPrimo(){
        try {
            FileWriter fileWriter = new FileWriter("C:\\Users\\User\\Desktop\\ejemplo\\primos.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            for(int num=1; num<=500;num++){
                if(esPrimo(num)){
                    bufferedWriter.write(Integer.toString(num));
                    bufferedWriter.newLine();
                }
            }
            bufferedWriter.close();
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }

    public static void leerPrimo(){
        File f = new File("C:\\Users\\User\\Desktop\\ejemplo\\primos.txt");
        Scanner entrada;
        try {
            entrada = new Scanner(f);
            while (entrada.hasNextLine()) {
                System.out.println(entrada.nextLine());
            }
            entrada.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        escribirPrimo();
        leerPrimo();
    }
}