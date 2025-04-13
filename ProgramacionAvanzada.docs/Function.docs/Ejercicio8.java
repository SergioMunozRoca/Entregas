package Function;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Ejercicio8 {
    public static void main(String[] args) {

        BiFunction<Integer,Integer,Double> potencia=(a, b) -> Math.pow(a,b);
        double resultado = potencia.apply(2,4);

        Function<Double,String> result = num -> num.toString();
        String numero = result.apply(resultado);
        System.out.println("Resultado: " + numero);
    }
}
