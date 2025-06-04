import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            FileWriter fileWriter = new FileWriter("C:\\Users\\User\\Desktop\\ejemplo\\numNaturales.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

           for(int num=1; num<=100;num++){
               System.out.println(num + "");
               bufferedWriter.write(Integer.toString(num));
               bufferedWriter.newLine();
           }
            bufferedWriter.close();
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }
}