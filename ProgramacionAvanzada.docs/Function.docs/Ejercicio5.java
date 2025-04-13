package Function;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Ejercicio5 {
    public static void main(String[] args) {

        BiFunction<Integer,Integer,Integer> suma = (a,b)->a+b;
        int resultado = suma.apply(8,7);
        System.out.println("Resultado: " + resultado);
    }
}
