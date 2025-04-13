package Function;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Ejercicio10 {

    public static <T, U, R> String calcular(T valor1, U valor2, BiFunction<T, U, R> operacion, Function<R, String> formatear) {
        return formatear.apply(operacion.apply(valor1, valor2));
    }

    public static void main(String[] args) {

        BiFunction<Integer, Integer, String> suma = (a, b) -> calcular(a, b, (x, y) -> x + y, resultado -> String.valueOf(resultado));
        String resultado = suma.apply(8,7);
        System.out.println("Resultado: " + resultado);
    }
}
