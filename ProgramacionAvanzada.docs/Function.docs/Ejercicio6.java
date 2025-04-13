package Function;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Ejercicio6 {
    public static void main(String[] args) {

        BiFunction<Integer,Integer,Double> potencia=(a, b) -> Math.pow(a,b);
        double resultado = potencia.apply(8,7);
        System.out.println("Resultado: " + resultado);
    }
}
