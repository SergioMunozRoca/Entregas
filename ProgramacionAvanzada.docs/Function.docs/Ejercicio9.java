package Function;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Ejercicio9 {
    public static void main(String[] args) {

        String resultado = calcularPotencia(2, 4);

        System.out.println(resultado);
    }

    public static String calcularPotencia(int base, int exponente) {

        BiFunction<Integer, Integer, Double> potencia = (a, b) -> Math.pow(a, b);
        Function<Double, String> formatearResultado = num -> "Resultado: " + num;

        return formatearResultado.apply(potencia.apply(base, exponente));
    }
}
