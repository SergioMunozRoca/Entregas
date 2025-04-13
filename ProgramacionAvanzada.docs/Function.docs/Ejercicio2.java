package Function;

import java.util.function.Function;

public class Ejercicio2 {
    public static void main(String[] args) {

        Function<Integer,Integer> potencia2= integer -> (int) Math.pow(2,integer);
        Integer valor = potencia2.apply(4);
        System.out.println("Valor: " + valor);
    }
}
