// Sergio Muñoz Roca-Esteban Mestre Córdoba Grupo: 2 M
import java.util.Scanner;

public class Concurso2M {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce un número de dígitos: ");
        int num = sc.nextInt();

        int multi = 0;

        for(int i = 0; i<num;i++){

            if (i %2 == 0){
                multi = i * 2;
            }else if(i %2 == 1){
                multi = i * 3;
            }
        }

        System.out.println(multi);

    }
}
