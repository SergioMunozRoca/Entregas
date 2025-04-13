package Function;

import java.util.function.Function;

public class Ejercicio7 {
    public static void main(String[] args) {

        Function<Double,String> result = numero -> numero.toString();
        String resultado = result.apply(8.0);
        System.out.println("Resultado: " + resultado);
    }
}
