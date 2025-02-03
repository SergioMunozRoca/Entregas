import java.lang.reflect.Array;
import java.util.Arrays;

public class MainRectangulo {
    public static void main(String[] args) {

        Rectangulo[] rectangulos = new Rectangulo[10];
        rectangulos[0] = new Rectangulo(2,3);
        rectangulos[1] = new Rectangulo(3,5);
        rectangulos[2] = new Rectangulo(5,9);
        rectangulos[3] = new Rectangulo(6,2);
        rectangulos[4] = new Rectangulo(7,2);
        rectangulos[5] = new Rectangulo(2,8);
        rectangulos[6] = new Rectangulo(4,9);
        rectangulos[7] = new Rectangulo(8,4);
        rectangulos[8] = new Rectangulo(3,8);
        rectangulos[9] = new Rectangulo(9,4);

        System.out.println("Antes de ordenar: ");
        for(Rectangulo rectangulo:rectangulos) {
            System.out.println(rectangulo);
        }

        System.out.println();

        Arrays.sort(rectangulos);

        System.out.println("Después de ordenar por área: ");
        for(Rectangulo rec: rectangulos) {
            System.out.println(rec);
        }
    }
}
